// Name: Katherine Reynolds
// Date: 3/11/2022
// File: Lab6.java

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Lab6 {

    /**
     *  Problem 1: Sort the list of neighbours for each vertex.
     */
    private static void problem1(Graph g) {

        // method that uses counting sort to sort the adjacency lists in ascending order
        for (int i = 0; i < g.noOfVertices; i++) {
            int[] count = new int[g.noOfVertices];
            for (int k = 0; k < g.edges[i].length; k++) {
                count[g.edges[i][k]]++;
            }
            for (int k = 0, j = 0; k < count.length; k++) {
                if (count[k] > 0) {
                    g.edges[i][j] = k;
                    ++j;
                }
            }
        }
    }

    /**
     *  Problem 2: Find the distances in a directed acyclic graph.
     */
    private static int[] problem2(Graph g, int startId) {

        // array where the distance between the startId and other other vertexes will be stored
        int[] distances = new int[g.noOfVertices];


        // setting the distance values to infinity
        for (int i = 0; i < distances.length; i++) {
            distances[i] = Integer.MAX_VALUE;
        }

        // startId distance will always be 0
        distances[startId] = 0;

        // for loop to go through adjacency lists and use the relax method to calculate the
        // shortest distance from startId to all other vertexes
        for (int i = 0; i < distances.length; i++) {
            for (int k = 0; k < g.edges[startId].length; k++) {
                g.relax(startId, k, distances);
            }
        }

        return distances;
    }

    // ---------------------------------------------------------------------
    // Do not change any of the code below!

    private static final int LabNo = 6;
    private static final Random rng = new Random(123456);

    private static boolean testProblem1(int[][] testCase) {
        Graph g = new Graph(testCase, false);
        Graph h = new Graph(testCase, false);

        problem1(g);

        if (g.noOfVertices != h.noOfVertices) return false;
        if (g.edges == null || g.edges.length != g.noOfVertices) return false;


        for (int vId = 0; vId < h.noOfVertices; vId++)
        {
            if (g.edges[vId] == null) return false;
            if (g.edges[vId].length != h.edges[vId].length) return false;

            Arrays.sort(h.edges[vId]);

            for (int i = 0; i < h.edges[vId].length; i++)
            {
                if (g.edges[vId][i] != h.edges[vId][i]) return false;
            }
        }

        return true;
    }

    private static boolean testProblem2(int[][] testCase) {
        int[][] graphData = Arrays.copyOf(testCase, testCase.length - 1);
        int startId = testCase[testCase.length - 1][0];

        Graph g = new Graph(graphData, true);

        int[] solution = g.bellmanFord(startId);
        int[] answer = problem2(g, startId);
        
         
        if (answer.length != solution.length) return false;

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] != solution[i]) return false;
        }

        return true;
    }

    public static void main(String args[]) {
        System.out.println("CS 302 -- Lab " + LabNo);
        testProblems(1);
        testProblems(2);
    }

    private static void testProblems(int prob) {
        int noOfLines = 5000;

        System.out.println("-- -- -- -- --");
        System.out.println(noOfLines + " test cases for problem " + prob + ".");

        boolean passedAll = true;

        for (int i = 1; i <= noOfLines; i++) {

            int[][] testCase = null;

            boolean passed = false;
            boolean exce = false;

            try {
                switch (prob) {
                    case 1:
                        testCase = createProblem1(i);
                        passed = testProblem1(testCase);
                        break;

                    case 2:
                        testCase = createProblem2(i);
                        passed = testProblem2(testCase);
                        break;
                }
            } catch (Exception ex) {
                 System.out.println(ex.toString());
                passed = false;
                exce = true;
            }

            if (!passed) {
                System.out.println("Test " + i + " failed!" + (exce ? " (Exception)" : ""));
                passedAll = false;
                break;
            }
        }

        if (passedAll) {
            System.out.println("All test passed.");
        }

    }

    private static int[][] createProblem1(int testNo) {
        int size = rng.nextInt(Math.min(1000, testNo)) + 10;

        ArrayList<HashSet<Integer>> graph = new ArrayList<HashSet<Integer>>(size);

        for (int i = 0; i < size; i++) {
            graph.add(new HashSet<Integer>());
        }

        for (int i = 1; i < size; i++) {
            int par = rng.nextInt(i);
            graph.get(i).add(par);
            graph.get(par).add(i);
        }

        int logSize = -1;
        for (int s = size; s > 0; s /= 2) logSize++;

        int avgDeg = rng.nextInt(logSize * logSize - 3) + 3;
        int edges = (avgDeg * size) / 2 - size + 1;

        for (int i = 0; i < edges; i++) {
            int uId = rng.nextInt(size);

            // Ensures vId != uId
            int vId = rng.nextInt(size - 1);
            if (vId >= uId) vId++;

            graph.get(uId).add(vId);
            graph.get(vId).add(uId);
        }

        int[][] testCase = new int[size][];
        for (int vId = 0; vId < size; vId++) {
            int deg = graph.get(vId).size();
            int[] neighs = new int[deg];

            int ctr = 0;
            for (Integer uId : graph.get(vId)) {
                neighs[ctr] = uId;
                ctr++;
            }

            shuffle(neighs);
            testCase[vId] = neighs;
        }

        return testCase;
    }

    private static int[][] createProblem2(int testNo) {
        int size = rng.nextInt(Math.min(1000, testNo)) + 10;

        ArrayList<ArrayList<Integer>> edgeSet = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> edgeWei = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < size; i++) {
            edgeSet.add(new ArrayList<Integer>());
            edgeWei.add(new ArrayList<Integer>());
        }

        int logSize = -1;
        for (int s = size; s > 0; s /= 2) logSize++;

        int avgDeg = rng.nextInt(logSize * logSize - 3) + 3;
        int edges = (avgDeg * size) / 2 - size + 1;

        for (int i = 1; i < size; i++) {
            int par = rng.nextInt(i);
            edgeSet.get(par).add(i);
            edgeWei.get(par).add(rng.nextInt(2 * logSize + 1) - logSize);
        }

        for (int i = 0; i < edges; i++) {
            int uvWei = rng.nextInt(2 * logSize + 1) - logSize;
            int uId = rng.nextInt(size);

            // Ensures vId != uId
            int vId = rng.nextInt(size - 1);
            if (vId >= uId) vId++;

            int fromId = Math.min(uId, vId);
            int toId = Math.max(uId, vId);

            edgeSet.get(fromId).add(toId);
            edgeWei.get(fromId).add(uvWei);
        }

        int[][] testCase = new int[2 * size + 1][];
        for (int vId = 0; vId < size; vId++) {
            int deg = edgeSet.get(vId).size();

            int[] neighs = new int[deg];
            int[] weights = new int[deg];

            for (int i = 0; i < deg; i++) {
                neighs[i] = edgeSet.get(vId).get(i);
                weights[i] = edgeWei.get(vId).get(i);
            }

            testCase[2 * vId] = neighs;
            testCase[2 * vId + 1] = weights;
        }

        // Start vertex.
        testCase[2 * size] = new int[] { rng.nextInt(size) };

        return testCase;
    }

    private static void shuffle(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int rndInd = rng.nextInt(arr.length - i) + i;
            int tmp = arr[i];
            arr[i] = arr[rndInd];
            arr[rndInd] = tmp;
        }
    }
}

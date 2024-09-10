/*
 Katherine Reynolds
 Assignment 10
 Cake.h
Calling of Cake object functions
*/

#pragma once
#include <list>
#include <string>

using namespace std;

class Cake {
public:
	// defualt constructor
	Cake();

	// print list 
	void printList();

	// add to list
	void addToCake(string element);

	// remove last element of list
	void removeFromOrder(string element);

private:
	list<string> order;
};
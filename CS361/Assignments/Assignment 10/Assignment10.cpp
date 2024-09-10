/*
 Katherine Reynolds
 Assignment 10
 Assignment10.cpp
 Main method
*/

#include <iostream>
#include "Cake.h"

using namespace std;

int main () {
	// creation of cake object on the heap
	auto myCake = make_unique<Cake>();

	// adding cake elements to the cake object
	myCake->addToCake("Two layers");
	myCake->addToCake("German chocolate cake");
	myCake->addToCake("Coconut Pecan frosting");
	myCake->addToCake("Round");

	// print cake object
	myCake->printList();

	// remove element from cake object
	myCake->removeFromOrder("Two layers");

	// print cake object with element removed 

	myCake->printList();
};
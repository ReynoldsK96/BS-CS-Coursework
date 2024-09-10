/*
 Katherine Reynolds
 Assignment 10
 Cake.cpp
 Implementation of Cake object functions
*/

#include <iostream>
#include <list>
#include <iterator>
#include <string>
#include "Cake.h"

using namespace std;

// default constructor
Cake::Cake() {}

// print out list
void Cake::printList() {
	list<string>::iterator it;
	for (it = order.begin(); it != order.end(); it++) {
		cout << *it << ", ";
	}
	cout << endl;
}

// add to list
void Cake::addToCake(string element) {
	order.push_front(element);
}

// remove last element of list
void Cake::removeFromOrder(string element) {
	order.remove(element);
}


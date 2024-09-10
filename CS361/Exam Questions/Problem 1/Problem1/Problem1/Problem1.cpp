/*
 Katherine Reynolds
 CS 361
 Final, Problem 1
 Problem1.cpp
 Main that uses range based for loop to print out enumerated class
*/

#include "Clothing.h"
#include <iostream>

using namespace std;

int main() {
    
	// range based for loop
	for (auto& theSize : Clothing::allSizes) {
		// switch statement to print out enumerated class
		switch (theSize) {
		case Clothing::clothingSize::P:
			cout << "P" << endl;
			break;
		case Clothing::clothingSize::S:
			cout << "S" << endl;
			break;
		case Clothing::clothingSize::M:
			cout << "M" << endl;
			break;
		case Clothing::clothingSize::L:
			cout << "L" << endl;
			break;
		case Clothing::clothingSize::XL:
			cout << "XL" << endl;
			break;
		case Clothing::clothingSize::XXL:
			cout << "XXL" << endl;
			break;
		case Clothing::clothingSize::XXXL:
			cout << "XXXL" << endl;
			break;
		}
	}
    
    return 0;
} 
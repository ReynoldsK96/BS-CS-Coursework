/*
 Katherine Reynolds
 CS 361
 Final, Problem 1
 Clothing.h
 Header file that contains the enumerated class and container hold each size
*/

#pragma once

using namespace std;

namespace Clothing {
	// enumerated class
	enum class clothingSize {
		P,
		S,
		M,
		L,
		XL,
		XXL,
		XXXL
	};

	// container holding each size
	static const clothingSize allSizes[] = {
		clothingSize::P,
		clothingSize::S,
		clothingSize::M,
		clothingSize::L,
		clothingSize::XL,
		clothingSize::XXL,
		clothingSize::XXXL
	};

}


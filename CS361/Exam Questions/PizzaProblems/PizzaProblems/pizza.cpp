/*
 Katherine Reynolds
 CS 361
 Final, Pizza problems
 pizza.cpp
 Contains implementation of problems 2 - 11
*/

#include "pizza.h"
#include <iostream>

// Problem 2
Pizza::Pizza(pizzaParts::crust crust, std::initializer_list<pizzaParts::topping> toppings) : mCrust(crust), mToppings(toppings) {}

// Problem 3
void Pizza::makeFavorite(Pizza* mPizza) {
	mPizza->mCrust;
	mPizza->mToppings;
}

// Problem 4
size_t Pizza::numberOfToppings() {
	return mToppings.size();
}

// Problem 5
void Pizza::addTopping(pizzaParts::topping topping) {
	mToppings.push_back(topping);
}

// Problem 6
bool Pizza::removeTopping(pizzaParts::topping topping) {
	for (auto& i : mToppings) {
		if (i == topping) {
			mToppings.remove(topping);
			return true;
		} 
	}
	return false;
}

// Problem 7
std::list<pizzaParts::topping> Pizza::getAllToppings() {
	return mToppings;
}

// Problem 8
void Pizza::addCrust(pizzaParts::crust myCrust) {
	mCrust = myCrust;
}

// Problem 9
void Pizza::changeCrust(pizzaParts::crust myCrust) {
	mCrust = myCrust;
}

// Problem 10
pizzaParts::crust Pizza::getCrust() {
	return mCrust;
}

// Problem 11
std::ostream& operator << (std::ostream& os, Pizza& myPizza) {
	for (auto& toppings : myPizza.getAllToppings()) {
		switch (toppings) {
		case pizzaParts::topping::pepperoni:
			os << "Pepperoni" << std::endl;
			break;
		case pizzaParts::topping::mushrooms:
			os << "Mushrooms" << std::endl;
			break;
		case pizzaParts::topping::peppers:
			os << "Peppers" << std::endl;
			break;
		case pizzaParts::topping::onions:
			os << "Onions" << std::endl;
			break;
		}
	}
	switch (myPizza.getCrust()) {
	case pizzaParts::crust::thin:
		os << "Thin" << std::endl;
		break;
	case pizzaParts::crust::hand_tossed:
		os << "Hand tossed" << std::endl;
		break;
	case pizzaParts::crust::pan:
		os << "Pan" << std::endl;
		break;
	case pizzaParts::crust::original:
		os << "Original" << std::endl;
		break;
	}
	return os;
}


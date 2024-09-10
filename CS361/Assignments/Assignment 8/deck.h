/*
 Katherine Reynolds
 CS 361
 Assignment 7
 deck.h
 Calling of functions that creates a deck of cards and deals from created deck
*/

#pragma once
#include <iostream>
#include <vector> 
#include "card.h"
using namespace std;

class deck {
public:
	// constructor, creates deck
	deck();
	
	// function that returns the size of the deck
	int deckSize();

	// function that deals a card
	card dealCard();

private:
	// private deck variables
	vector<card> myDeck;
};

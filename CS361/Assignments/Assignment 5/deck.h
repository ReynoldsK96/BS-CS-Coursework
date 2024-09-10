/*
 Katherine Reynolds
 CS 361
 Assignment 5
 deck.h
 Header file that populates a deck of cards, deals cards, and returns the number of remaining card.
*/

#pragma once
#include <iostream>
#include <vector> 
#include "card.h"
using namespace std;

class Deck {
public:
	// constructor, creates deck
	Deck();

	// function that returns the size of the deck
	int deckSize();

	// function that deals a card
	Card dealCard();

private:
	vector<Card> myDeck;
};

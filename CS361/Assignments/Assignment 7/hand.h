/*
 Katherine Reynolds
 CS 361
 Assignment 8
 hand.h
 Calling of functions that create a hand of cards, adds to a hand of cards,
 and determines the highest and lowest values in a hand of cards.
*/

#pragma once
#include <iostream>
#include <vector> 
#include "card.h"
using namespace std;

class hand {
public:
	
	// constructor, creates a hand of cards by dealing cards from a deck
	hand();

	// adds another card to hand
	void addCardToHand(card dealtCard);

	// prints cards in hand out 
	void drawHand();

	// returns the lowest value in hand
	int handValueLow();

	// returns the highest value in hand
	int handValueHigh();

private: 
	// private hand variables
	vector<card> myHand;

	int calculateHandValue(card myCard, int handValue);
};
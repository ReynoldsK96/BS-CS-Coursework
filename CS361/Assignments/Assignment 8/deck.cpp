/*
 Katherine Reynolds
 CS 361
 Assignment 7
 deck.cpp
 Implementation of functions that creates a deck of cards and deals from created deck
*/

#include <iostream>
#include "card.h"
#include "deck.h"
using namespace std;

// constructor, creates deck
deck::deck() {
	card* newCard = new card();

	for (cards::cardSuit suit : cards::allSuits) {
		for (cards::cardValue value : cards::allValues) {
			newCard->setCardSuit(suit);
			newCard->setCardValue(value);
			myDeck.push_back(*newCard);
		}
	}

	delete newCard;
}

// function that returns the size of the deck
int deck::deckSize() {
	return myDeck.size();
}

// function that deals a card
card deck::dealCard() {
	card dealtCard;
	srand(time(0));
	int randomNum = rand() % myDeck.size();
	dealtCard = myDeck.at(randomNum);
	myDeck.erase(myDeck.begin() + randomNum);
	return dealtCard;
}
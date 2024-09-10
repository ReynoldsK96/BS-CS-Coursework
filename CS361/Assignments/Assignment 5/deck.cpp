#include <iostream>
#include "card.h"
#include "deck.h"
using namespace std;

// constructor, creates deck
Deck::Deck() {
	Card* newCard = new Card();

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
int Deck::deckSize() {
	return myDeck.size();
}

// function that deals a card
Card Deck::dealCard() {
	Card dealtCard;
	srand(time(0));
	int randomNum = rand() % myDeck.size();
	dealtCard = myDeck.at(randomNum);
	myDeck.erase(myDeck.begin() + randomNum);
	return dealtCard;
}

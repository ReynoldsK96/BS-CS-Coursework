#include <iostream>
#include "deck.h"
#include "card.h"
using namespace std;

int main() {
	Deck myDeck;
	Card myCard;
	
	cout << "the original deck size is " << myDeck.deckSize() << endl << endl;
	cout << "the next card dealt is:" << endl;

	cout << "the original deck size is " << myDeck.deckSize() << endl << endl;
	cout << "the next card dealt is:" << endl;
	
	myCard = myDeck.dealCard();
	myCard.drawCard();
	
	cout << "the deck size is now " << myDeck.deckSize() << endl << endl;
	cout << "the next card dealt is:" << endl;
	
	myCard = myDeck.dealCard();
	myCard.drawCard();
	
	cout << "the deck size is now " << myDeck.deckSize() << endl << endl;
	cout << "the next card dealt is:" << endl;
	
	myCard = myDeck.dealCard();
	myCard.drawCard();
	
	cout << "the deck size is now " << myDeck.deckSize() << endl << endl;
	cout << endl << endl;

}
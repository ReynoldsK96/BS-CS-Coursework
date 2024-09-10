#include <iostream>
#include "card.h"
using namespace std;

// card constructor 
Card::Card(cards::cardSuit theCardSuit, cards::cardValue theCardValue) : suit(theCardSuit), value(theCardValue) {}

// setter method for setting card's suit
void Card::setCardSuit(cards::cardSuit theCardSuit) {
    suit = theCardSuit;
}

// setter method for setting card's value
void Card::setCardValue(cards::cardValue theCardValue) {
    value = theCardValue;
}

// getter method for getting card's value
cards::cardValue Card::getCardValue() {
    return value;
}

// function that draws cards
void Card::drawCard() {
    // for loop that ittirates from the top to the bottom of a card
    for (int i = 0; i < 11; i++) {
        // prints out the top border of the card
        if (i == 0) {
            cout << char(201) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(187) << endl;
        }

        // prints out the 2nd row of the card, with the value and suit in the top left corner
        else if (i == 1) {
            cout << char(186);
            printCardValue(value);
            printCardSuit(suit);

            // determines if the value is 10 or not so the right number of spaces are printed
            if (value == cards::cardValue::Ten) {
                cout << "       " << char(186) << endl;
            }
            else {
                cout << "        " << char(186) << endl;

            }
        }

        // prints out rows 3 through 9 of the card
        else if (1 < i && i < 9) {
            cout << char(186) << "          " << char(186) << endl;
        }

        // prints out row 10 of the card, with the value and suit in the bottom right corner
        else if (i == 9) {
            if (value == cards::cardValue::Ten) {
                cout << char(186) << "       ";
            }
            else {
                cout << char(186) << "        ";
            }
            printCardValue(value);
            printCardSuit(suit);
            cout << char(186) << endl;
        }

        // prints out the bottom border of the card
        else if (i == 10) {
            cout << char(200) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(188) << endl;
        }
    }
}

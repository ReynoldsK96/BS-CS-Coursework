/*
 Katherine Reynolds
 CS 361
 Assignment 7
 card.cpp
 Implementation of functions that creates and print out card objects
*/

#include <iostream>
#include "card.h"
using namespace std;

// card default constructor
card::card() {}

// card constructor 
card::card(cards::cardSuit theCardSuit, cards::cardValue theCardValue) : suit(theCardSuit), value(theCardValue) {}

// setter method for setting card's suit
void card::setCardSuit(cards::cardSuit theCardSuit) {
    suit = theCardSuit;
}

// setter method for setting card's value
void card::setCardValue(cards::cardValue theCardValue) {
    value = theCardValue;
}

// getter method for getting card's value
cards::cardValue card::getCardValue() {
    return value;
}
// getter method for getting card's suit
cards::cardSuit card::getCardSuit() {
    return suit;
}


// prints out card's value
void card::printCardValue(cards::cardValue value, ostream& os) {
    switch (value) {
    case cards::cardValue::Ace:
        os << char(65);
        break;
    case cards::cardValue::Two:
        os << char(50);
        break;
    case cards::cardValue::Three:
        os << char(51);
        break;
    case cards::cardValue::Four:
        os << char(52);
        break;
    case cards::cardValue::Five:
        os << char(53);
        break;
    case cards::cardValue::Six:
        os << char(54);
        break;
    case cards::cardValue::Seven:
        os << char(55);
        break;
    case cards::cardValue::Eight:
        os << char(56);
        break;
    case cards::cardValue::Nine:
        os << char(57);
        break;
    case cards::cardValue::Ten:
        os << char(49) << char(48);
        break;
    case cards::cardValue::Jack:
        os << char(74);
        break;
    case cards::cardValue::Queen:
        os << char(81);
        break;
    case cards::cardValue::King:
        os << char(75);
        break;
    }
}

// prints out card's suit
void card::printCardSuit(cards::cardSuit suit, ostream& os) {
    switch (suit) {
    case cards::cardSuit::spade:
        os << "\x06";
        break;
    case cards::cardSuit::heart:
        os << "\x03";
        break;
    case cards::cardSuit::club:
        os << "\x05";
        break;
    case cards::cardSuit::diamond:
        os << "\x04";
        break;
    }
}

// overloaded operator that prints out card
ostream& operator << (ostream& os, card& myCard) {
    // for loop that ittirates from the top to the bottom of a card
    for (int i = 0; i < 11; i++) {
        // prints out the top border of the card
        if (i == 0) {
            os << char(201) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(187) << endl;
        }

        // prints out the 2nd row of the card, with the value and suit in the top left corner
        else if (i == 1) {
            os << char(186);
            myCard.printCardValue(myCard.getCardValue(), os);
            myCard.printCardSuit(myCard.getCardSuit(), os);

            // determines if the value is 10 or not so the right number of spaces are printed
            if (myCard.getCardValue() == cards::cardValue::Ten) {
                os << "       " << char(186) << endl;
            }
            else {
                os << "        " << char(186) << endl;

            }
        }

        // prints out rows 3 through 9 of the card
        else if (1 < i && i < 9) {
            os << char(186) << "          " << char(186) << endl;
        }

        // prints out row 10 of the card, with the value and suit in the bottom right corner
        else if (i == 9) {
            if (myCard.getCardValue() == cards::cardValue::Ten) {
                os << char(186) << "       ";
            }
            else {
                os << char(186) << "        ";
            }
            myCard.printCardValue(myCard.getCardValue(), os);
            myCard.printCardSuit(myCard.getCardSuit(), os);
            os << char(186) << endl;
        }

        // prints out the bottom border of the card
        else if (i == 10) {
            os << char(200) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(188);
        }
    }
    return os;
}
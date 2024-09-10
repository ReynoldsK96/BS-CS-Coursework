/*
 Katherine Reynolds
 CS 361
 Assignment 6
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

// function that draws cards
void card::drawCard() {
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

// prints out card's value
void card::printCardValue(cards::cardValue value) {
    switch (value) {
    case cards::cardValue::Ace:
        cout << char(65);
        break;
    case cards::cardValue::Two:
        cout << char(50);
        break;
    case cards::cardValue::Three:
        cout << char(51);
        break;
    case cards::cardValue::Four:
        cout << char(52);
        break;
    case cards::cardValue::Five:
        cout << char(53);
        break;
    case cards::cardValue::Six:
        cout << char(54);
        break;
    case cards::cardValue::Seven:
        cout << char(55);
        break;
    case cards::cardValue::Eight:
        cout << char(56);
        break;
    case cards::cardValue::Nine:
        cout << char(57);
        break;
    case cards::cardValue::Ten:
        cout << char(49) << char(48);
        break;
    case cards::cardValue::Jack:
        cout << char(74);
        break;
    case cards::cardValue::Queen:
        cout << char(81);
        break;
    case cards::cardValue::King:
        cout << char(75);
        break;
    }
}

// prints out card's suit
void card::printCardSuit(cards::cardSuit suit) {
    switch (suit) {
    case cards::cardSuit::spade:
        cout << "\x06";
        break;
    case cards::cardSuit::heart:
        cout << "\x03";
        break;
    case cards::cardSuit::club:
        cout << "\x05";
        break;
    case cards::cardSuit::diamond:
        cout << "\x04";
        break;
    }
}
/*
 Katherine Reynolds
 CS 361
 Assignment 9
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

// overloaded operator that prints out card
ostream& operator << (ostream& os, card& myCard) {
    switch (myCard.getCardValue()) {
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

    switch (myCard.getCardSuit()) {
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

    return os;
}
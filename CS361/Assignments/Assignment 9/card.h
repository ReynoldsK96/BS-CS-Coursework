/*
 Katherine Reynolds
 CS 361
 Assignment 9
 card.h
 Calling of functions that create and print out card object
*/

#pragma once 
#include <iostream>
using namespace std;

// setting up values for the possible card values and suits
namespace cards {
    enum class cardSuit {
        spade,
        heart,
        club,
        diamond
    };

    enum class cardValue {
        Ace,
        Two,
        Three,
        Four,
        Five,
        Six,
        Seven,
        Eight,
        Nine,
        Ten,
        Jack,
        Queen,
        King
    };

    static const cardSuit allSuits[] = {
        cardSuit::spade,
        cardSuit::heart,
        cardSuit::club,
        cardSuit::diamond
    };

    static const cardValue allValues[] = {
        cardValue::Ace,
        cardValue::Two,
        cardValue::Three,
        cardValue::Four,
        cardValue::Five,
        cardValue::Six,
        cardValue::Seven,
        cardValue::Eight,
        cardValue::Nine,
        cardValue::Ten,
        cardValue::Jack,
        cardValue::Queen,
        cardValue::King
    };
}

class card {
public:

    // default constructor
    card();

    // constructor 
    card(cards::cardSuit theCardSuit, cards::cardValue theCardValue);

    // setter method for setting card's suit
    void setCardSuit(cards::cardSuit theCardSuit);

    // setter method for setting card's value
    void setCardValue(cards::cardValue theCardValue);

    // getter method for getting card's value
    cards::cardValue getCardValue();

    // getter method for getting card's suit
    cards::cardSuit getCardSuit();

    // overloaded operator that prints out card
    friend ostream& operator << (ostream& os, card& myCard);

private:
    // private card variables
    cards::cardSuit suit;
    cards::cardValue value;
};

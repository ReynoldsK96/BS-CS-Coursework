/*
 Katherine Reynolds
 CS 361
 Assignment 7
 hand.cpp
 Implementation of functions that create a hand of cards, adds to a hand of cards,
 and determines the highest and lowest values in a hand of cards. 
*/

#include <iostream>
#include "card.h"
#include "deck.h"
#include "hand.h"
using namespace std;

// constructor, creates a hand of cards by dealing cards from a deck
hand::hand() {}

// adds another card to hand
void hand::addCardToHand(card dealtCard) {
	myHand.push_back(dealtCard);
}

// prints cards in hand out
void hand::drawHand() {
	for (card myCard : myHand) {
        cout << myCard << endl;
	}
}

// returns the lowest value in hand
int hand::handValueLow() {
    int lowValue = 0;
	
    for (card myCard : myHand) {
        if (myCard.getCardValue() == cards::cardValue::Ace) {
            lowValue += 1;
        } 
        else {
            lowValue = calculateHandValue(myCard, lowValue);
        }
    }

	return lowValue;
}

// returns the highest value in hand
int hand::handValueHigh() {
    int highValue = 0;
    bool ace = false;
    
    for (card myCard : myHand) {
        if (myCard.getCardValue() == cards::cardValue::Ace && ace == false) {
            highValue += 11;
            ace = true;
        }  
        else if (myCard.getCardValue() == cards::cardValue::Ace && ace == true) {
            highValue += 1;
        }
        else {
            highValue = calculateHandValue(myCard, highValue);
        }
    }
	
	return highValue;
}

// calculates values not equal to ace
int hand::calculateHandValue(card myCard, int handValue) {
    cards::cardValue myCardValue;
   
    myCardValue = myCard.getCardValue();
    
    switch (myCardValue) {
    case cards::cardValue::Two:
        handValue += 2;
        break;
    case cards::cardValue::Three:
        handValue += 3;
        break;
    case cards::cardValue::Four:
        handValue += 4;
        break;
    case cards::cardValue::Five:
        handValue += 5;
        break;
    case cards::cardValue::Six:
        handValue += 6;
        break;
    case cards::cardValue::Seven:
        handValue += 7;
        break;
    case cards::cardValue::Eight:
        handValue += 8;
        break;
    case cards::cardValue::Nine:
        handValue += 9;
        break;
    case cards::cardValue::Ten:
    case cards::cardValue::Jack:
    case cards::cardValue::Queen:
    case cards::cardValue::King:
        handValue += 10;
        break;
    default:
        cout << "Not a card value." << endl;
    }
    
    return handValue;
}


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

class Card {
public:
    // default constructor
    Card();

    // constructor 
    Card(cards::cardSuit theCardSuit, cards::cardValue theCardValue);

    // setter method for setting card's suit
    void setCardSuit(cards::cardSuit theCardSuit);

    // setter method for setting card's value
    void setCardValue(cards::cardValue theCardValue);

    // getter method for getting card's value
    cards::cardValue getCardValue();

    // function that draws cards
    void drawCard();

private:
    // private card variables
    cards::cardSuit suit;
    cards::cardValue value;

    // prints out card's value
    void printCardValue(cards::cardValue value) {
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
    void printCardSuit(cards::cardSuit suit) {
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
};




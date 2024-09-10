/*
 Katherine Reynolds
 CS 361
 Assignment 4
 Asgn3main.cpp
 Prints out a deck of cards when supplied with a suit and value, not including Joker.
*/

#include <iostream>

using namespace std;

// enum class for the value of the card
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

// enum class for the suit of the card
enum class cardSuit {
    Spade,
    Heart,
    Club,
    Diamond
};

// function to print out the card value on the top left
void PrintCardValueLeft(cardValue theCardValue) {
    switch (theCardValue) {
    case cardValue::Ace:
        cout << char(186) << char(65);
        break;
    case cardValue::Two:
        cout << char(186) << char(50);
        break;
    case cardValue::Three:
        cout << char(186) << char(51);
        break;
    case cardValue::Four:
        cout << char(186) << char(52);
        break;
    case cardValue::Five:
        cout << char(186) << char(53);
        break;
    case cardValue::Six:
        cout << char(186) << char(54);
        break;
    case cardValue::Seven:
        cout << char(186) << char(55);
        break;
    case cardValue::Eight:
        cout << char(186) << char(56);
        break;
    case cardValue::Nine:
        cout << char(186) << char(57);
        break;
    case cardValue::Ten:
        cout << char(186) << char(49) << char(48);
        break;
    case cardValue::Jack:
        cout << char(186) << char(74);
        break;
    case cardValue::Queen:
        cout << char(186) << char(81);
        break;
    case cardValue::King:
        cout << char(186) << char(75);
        break;
    }
}

// function to print out suit on the top left with the appropriate number of spaces if the value is 10
// the number of spaces has to be one less due to the extra digit in 10
void PrintCardSuitTenLeft(cardSuit theCardSuit) {
    switch (theCardSuit) {
    case cardSuit::Spade:
        cout << "\x06" << "       " << char(186) << endl;
        break;
    case cardSuit::Heart:
        cout << "\x03" << "       " << char(186) << endl;
        break;
    case cardSuit::Club:
        cout << "\x05" << "       " << char(186) << endl;
        break;
    case cardSuit::Diamond:
        cout << "\x04" << "       " << char(186) << endl;
        break;
    }
}

// function to print out suit on the top left with the appropriate number of spaces if the value is not 10
// the number of spaces has to be one more due to the extra digit in 10
void PrintCardSuitNotTenLeft(cardSuit theCardSuit) {
    switch (theCardSuit) {
    case cardSuit::Spade:
        cout << "\x06" << "        " << char(186) << endl;
        break;
    case cardSuit::Heart:
        cout << "\x03" << "        " << char(186) << endl;
        break;
    case cardSuit::Club:
        cout << "\x05" << "        " << char(186) << endl;
        break;
    case cardSuit::Diamond:
        cout << "\x04" << "        " << char(186) << endl;
        break;
    }
}

// function of print out card value on the bottom left
void PrintCardValueRight(cardValue theCardValue) {
    switch (theCardValue) {
    case cardValue::Ace:
        cout << char(186) << "        " << char(65);
        break;
    case cardValue::Two:
        cout << char(186) << "        " << char(50);
        break;
    case cardValue::Three:
        cout << char(186) << "        " << char(51);
        break;
    case cardValue::Four:
        cout << char(186) << "        " << char(52);
        break;
    case cardValue::Five:
        cout << char(186) << "        " << char(53);
        break;
    case cardValue::Six:
        cout << char(186) << "        " << char(54);
        break;
    case cardValue::Seven:
        cout << char(186) << "        " << char(55);
        break;
    case cardValue::Eight:
        cout << char(186) << "        " << char(56);
        break;
    case cardValue::Nine:
        cout << char(186) << "        " << char(57);
        break;
    case cardValue::Ten:
        cout << char(186) << "       " << char(49) << char(48);
        break;
    case cardValue::Jack:
        cout << char(186) << "        " << char(74);
        break;
    case cardValue::Queen:
        cout << char(186) << "        " << char(81);
        break;
    case cardValue::King:
        cout << char(186) << "        " << char(75);
        break;
    }
}

// function to print out card suit on the bottom left
void PrintCardSuitRight(cardSuit theCardSuit) {
    switch (theCardSuit) {
    case cardSuit::Spade:
        cout << "\x06" << char(186) << endl;
        break;
    case cardSuit::Heart:
        cout << "\x03" << char(186) << endl;
        break;
    case cardSuit::Club:
        cout << "\x05" << char(186) << endl;
        break;
    case cardSuit::Diamond:
        cout << "\x04" << char(186) << endl;
        break;
    }
}

// function that draws cards
void DrawCard(cardValue theCardValue, cardSuit theCardSuit) {
    // for loop that ittirates from the top to the bottom of a card
    for (int i = 0; i < 11; i++) {
        // prints out the top border of the card
        if (i == 0) {
            cout << char(201) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(187) << endl;
        }
        
        // prints out the 2nd row of the card, with the value and suit in the top left corner
        else if (i == 1) {
            PrintCardValueLeft(theCardValue);
            
            // determines if the value is 10 or not so the right number of spaces are printed
            if (theCardValue == cardValue::Ten) {
                PrintCardSuitTenLeft(theCardSuit);
            }
            else {
                PrintCardSuitNotTenLeft(theCardSuit);
            }
        }
        
        // prints out rows 3 through 9 of the card
        else if (1 < i && i < 9) {
            cout << char(186) << "          " << char(186) << endl;
        }

        // prints out row 10 of the card, with the value and suit in the bottom right corner
        else if (i == 9) {
            PrintCardValueRight(theCardValue);
            PrintCardSuitRight(theCardSuit);
        }
        
        // prints out the bottom border of the card
        else if (i == 10) {
            cout << char(200) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(205) << char(188) << endl;
        }
    }
}

// main function that determines which cards are drawn
int main() {
    cardValue theCardValue = cardValue::Ten;
    cardSuit theCardSuit = cardSuit::Spade;
    DrawCard(theCardValue, theCardSuit);

    theCardValue = cardValue::Jack;
    theCardSuit = cardSuit::Heart;
    DrawCard(theCardValue, theCardSuit);

    theCardValue = cardValue::Ace;
    theCardSuit = cardSuit::Club;
    DrawCard(theCardValue, theCardSuit);

    theCardValue = cardValue::Five;
    theCardSuit = cardSuit::Diamond;
    DrawCard(theCardValue, theCardSuit);

    return 0;
}

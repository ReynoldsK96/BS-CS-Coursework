/*
 Katherine Reynolds
 CS 361
 Assignment 7
 Assignment7.cpp
 Main method that is used to play a game of blackjack
*/

#include <iostream>
#include "card.h"
#include "deck.h"
#include "hand.h"

using namespace std;

int main() {
    // conditional variables
    bool play = true;
    string keepPlaying;

    // while player continues to input yes after each game the loop will run
    while (play == true) {
        // the deck
        deck myDeck;
        // player hand
        hand myHand;
        // dealer hand
        hand dealerHand;

        // deal first card to player
        myHand.addCardToHand(myDeck.dealCard());

        // deal second card to player
        myHand.addCardToHand(myDeck.dealCard());

        // variable to accept user input to hit or stand
        string playerInput;
        // variable to store whether player has gone over 21
        string playerStatus;

        while (playerInput != "Stand" || playerInput != "stand") {

            // if low hand value is over 21 the player has bust
            if (myHand.handValueLow() > 21) {
                playerStatus = "bust";
                break;
            }

            // prints cards in hand out
            myHand.drawHand();

            // reports to player what the low and high value of the hand is
            cout << "Your hand's low  value is " << myHand.handValueLow() << endl;
            cout << "Your hand's high value is " << myHand.handValueHigh() << endl;

            // collect user input on whether they would like another card or not
            cout << "Hit or Stand?: ";
            cin >> playerInput;

            // if player enters hit another card is dealt to their hand
            if (playerInput == "Hit" || playerInput == "hit") {
                myHand.addCardToHand(myDeck.dealCard());
                continue;
            }
            // if player enters stand the loop breaks
            if (playerInput == "Stand") {
                break;
            }
            // functionality to catch if user enters incorrect input
            else {
                cout << "Unacceptable input, try again." << endl;
                continue;
            }
        }

        // deal first card to dealer
        dealerHand.addCardToHand(myDeck.dealCard());

        // deal second card to dealer
        dealerHand.addCardToHand(myDeck.dealCard());

        // variable to store whether dealer has gone over 21, while loop breaks if dealer goes over 21
        string dealerStatus;

        // runs as long as both the player and the dealer are not over 21 
        while (playerStatus != "bust" && dealerStatus != "bust") {
            
            // get low and high hand value for assessment whether the dealer hits or stands
            int lowValue = dealerHand.handValueLow();
            int highValue = dealerHand.handValueHigh();

            // if high value is less then or equal to 16, another card is dealt to the dealer
            if (highValue <= 16) {
                dealerHand.addCardToHand(myDeck.dealCard());
                continue;
            }
            // if high value is greater than or equal to 17 and less than or equal to 21, the dealer stands and the loop breaks
            if (highValue >= 17 && highValue <= 21) {
                break;
            }
            // if low value is greater then 21, the dealer has lost and the loop breaks
            if (lowValue > 21) {
                dealerStatus = "bust";
                continue;
            }
        }

        // reports the high and low value of the player's and dealer's hands  
        cout << "Your hand is worth: " << myHand.handValueLow() << " or " << myHand.handValueHigh() << endl;
        cout << "Dealer's hand value is worth: " << dealerHand.handValueLow() << " or " << dealerHand.handValueHigh() << endl;

        // if the player has gone over 21 they lose and the dealer wins
        if (playerStatus == "bust") {
            cout << "Dealer wins." << endl;
        }
        // if the dealer has gone over 21 they lose and the player wins
        else if (dealerStatus == "bust") {
            cout << "Player wins." << endl;
        }
        // if the player's high hand value is less than the dealer's high hand value, the dealer wins
        else if (myHand.handValueHigh() < dealerHand.handValueHigh()) {
            cout << "Dealer wins." << endl;
        }
        // if the player's high hand value is greater than the dealer's high hand value, the player wins
        else if (myHand.handValueHigh() > dealerHand.handValueHigh()) {
            cout << "Player wins." << endl;
        }
        // if the player's and dealer's high hand value are equal then it is a draw
        else if (myHand.handValueHigh() == dealerHand.handValueHigh()) {
            cout << "Draw." << endl;
        }
        
        
        // assesses whether the player would like to play again
        cout << "Do you want to play again?: ";
        cin >> keepPlaying;

        // if yes is entered the loop continues running and another game is played
        if (keepPlaying == "Yes" || keepPlaying == "yes") {
            continue;
        }
        // if no is entered the loop ends
        if (keepPlaying == "No" || keepPlaying == "no") {
            cout << "Goodbye.";
            play = false;
        }
        // if a different response is entered, the loop ends
        else {
            cout << "Unacceptable input, try again." << endl;
            play = false;
        }

    }
}


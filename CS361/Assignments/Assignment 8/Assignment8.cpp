/*
 Katherine Reynolds
 CS 361
 Assignment 8
 Assignment7.cpp
 Main method that is used to play a game of blackjack
*/

#include <iostream>
#include <memory>
#include "card.h"
#include "deck.h"
#include "hand.h"

using namespace std;

int main() {
    // conditional variables
    int gameStatus = 0;
    bool play = true;
    string keepPlaying;
    
    // variables to keep track of number of wins and losses
    int wins = 0;
    int losses = 0;
   

    // while player continues to input yes after each game the loop will run
    while (play) {
        // the deck
        deck myDeck;
        
        // player hand
        auto playerHand = make_unique<hand>();
        
        // dealer hand
        auto dealerHand = make_unique<hand>();

        // deal first card to player
       playerHand->addCardToHand(myDeck.dealCard());

        // deal first card to dealer
        dealerHand->addCardToHand(myDeck.dealCard());
        
        cout << "The dealer's first card is:" << endl;
        // prints out dealer's face up card
        dealerHand->drawHand();

        // deal second card to player
        playerHand->addCardToHand(myDeck.dealCard());

        // deal second card to dealer
        dealerHand->addCardToHand(myDeck.dealCard());

        // variable to accept user input to hit or stand
        string playerInput;

        // the player's turn
        while (playerInput != "Stand" && playerInput != "stand") {

            // if low hand value is over 21 the player has bust and the loop breaks
            if (playerHand->handValueLow() > 21) {
                gameStatus = 1;
                break;
            }

            cout << "Your hand is:" << endl;
            // prints cards in hand out
            playerHand->drawHand();

            // reports to player what the low and high value of the hand is
            cout << "Your hand's low  value is " << playerHand->handValueLow() << endl;
            cout << "Your hand's high value is " << playerHand->handValueHigh() << endl;

            // collect user input on whether they would like another card or not
            cout << "Hit or Stand?: ";
            cin >> playerInput;

            // if player enters hit another card is dealt to their hand
            if (playerInput == "Hit" || playerInput == "hit") {
                playerHand->addCardToHand(myDeck.dealCard());
                continue;
            }
            // if player enters stand the loop breaks
            if (playerInput == "Stand" || playerInput == "stand") {
                break;
            }
            // functionality to catch if user enters incorrect input
            else {
                cout << "Unacceptable input, try again." << endl;
                continue;
            }
        }

        // the dealer's turn
        while (gameStatus == 0) {

            // get low and high hand value for assessment whether the dealer hits or stands
            int lowValue = dealerHand->handValueLow();
            int highValue = dealerHand->handValueHigh();

            if (lowValue == 21 || highValue == 21) {
                gameStatus = 3;
                continue;
            }

            // if high value is less then or equal to 16, another card is dealt to the dealer
            if (highValue <= 16) {
                dealerHand->addCardToHand(myDeck.dealCard());
                continue;
            }
            // if high value is greater than or equal to 17 and less than or equal to 21, the dealer stands and the loop breaks
            if (highValue >= 17 && highValue <= 21) {
                break;
            }
            // if low value is greater then 21, the dealer has lost and the loop breaks
            if (lowValue > 21) {
                gameStatus = 2;
                continue;
            }
        }

        // switch statement to account for the number of ways a game can end
        switch (gameStatus) {
        // in the case of 0 neither the player or dealer busted and the game is detemined by who had the highest hand
        case 0:
            // reports the high and low value of the player's and dealer's hands  
            cout << "Your hand is worth: " << playerHand->handValueLow() << " or " << playerHand->handValueHigh() << endl;
            cout << "Dealer's hand value is worth: " << dealerHand->handValueLow() << " or " << dealerHand->handValueHigh() << endl;

            // if the player's high hand value is less than the dealer's high hand value, the dealer wins
            if (playerHand->handValueHigh() < dealerHand->handValueHigh()) {
                cout << "Dealer wins." << endl;
                losses++;
            }
            // if the player's high hand value is greater than the dealer's high hand value, the player wins
            else if (playerHand->handValueHigh() > dealerHand->handValueHigh()) {
                cout << "Player wins." << endl;
                wins++;
            }
            // if the player's and dealer's high hand value are equal then it is a draw
            else if (playerHand->handValueHigh() == dealerHand->handValueHigh()) {
                cout << "Draw, game is a push." << endl;
            }
            break;
        // in the case of 1 the player busted and the dealer wins
        case 1:
            cout << "The player busted, dealer wins!" << endl;
            losses++;
            break;
        // in the case of 2 the dealer busted and the player wins
        case 2:
            cout << "The dealer busted, player wins!" << endl;
            wins++;
            break;
        // in the case of 3 the dealer got Blackjack and the dealer wins
        case 3:
            cout << "Dealer has Blackjack. Dealer wins!" << endl;
            losses++;
        }

        // resets for a potential next game
        playerHand.release();
        dealerHand.release();
        gameStatus = 0;

        // reports the wins and losses a player has received 
        cout << "Wins: " << wins << endl;
        cout << "Losses: " << losses << endl;
        
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
            cout << "Unacceptable input, goodbye." << endl;
            play = false;
        }
    }
    return 0;

}
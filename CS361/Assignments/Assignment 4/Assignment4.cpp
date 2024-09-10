#include <iostream>
#include "card.h"
using namespace std;
int main() {
    // create the 10 of spades and draw it
    card* myCard = new card(cards::cardSuit::spade, cards::cardValue::Ten);
    myCard->drawCard();

    // set the card to the jack of hearts and draw it
    myCard->setCardSuit(cards::cardSuit::heart);
    myCard->setCardValue(cards::cardValue::Jack);
    myCard->drawCard();
    
    // set the card to the ace of clubs and draw it
    myCard->setCardSuit(cards::cardSuit::club);
    myCard->setCardValue(cards::cardValue::Ace);
    myCard->drawCard();
    
    // set the card to the five of diamonds and draw it
    myCard->setCardSuit(cards::cardSuit::diamond);
    myCard->setCardValue(cards::cardValue::Five);
    myCard->drawCard();
}
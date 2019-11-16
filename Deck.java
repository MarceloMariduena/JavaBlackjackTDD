package com.company;

/**
 * @author: Marcelo Mariduena
 */

import java.util.ArrayList;

public class Deck {
    ArrayList<Card> deck;

    public Deck() {
        deck = new ArrayList<Card>();

        deck.add(new Card ("2", "Hearts"));
        deck.add(new Card ("3", "Hearts"));
        deck.add(new Card ("4", "Hearts"));
        deck.add(new Card ("5", "Hearts"));
        deck.add(new Card ("6", "Hearts"));
        deck.add(new Card ("7", "Hearts"));
        deck.add(new Card ("8", "Hearts"));
        deck.add(new Card ("9", "Hearts"));
        deck.add(new Card ("10", "Hearts"));
        deck.add(new Card ("J", "Hearts"));
        deck.add(new Card ("Q", "Hearts"));
        deck.add(new Card ("K", "Hearts"));
        deck.add(new Card ("A", "Hearts"));

        deck.add(new Card ("2", "Spades"));
        deck.add(new Card ("3", "Spades"));
        deck.add(new Card ("4", "Spades"));
        deck.add(new Card ("5", "Spades"));
        deck.add(new Card ("6", "Spades"));
        deck.add(new Card ("7", "Spades"));
        deck.add(new Card ("8", "Spades"));
        deck.add(new Card ("9", "Spades"));
        deck.add(new Card ("10", "Spades"));
        deck.add(new Card ("J", "Spades"));
        deck.add(new Card ("Q", "Spades"));
        deck.add(new Card ("K", "Spades"));
        deck.add(new Card ("A", "Spades"));

        deck.add(new Card ("2", "Diamonds"));
        deck.add(new Card ("3", "Diamonds"));
        deck.add(new Card ("4", "Diamonds"));
        deck.add(new Card ("5", "Diamonds"));
        deck.add(new Card ("6", "Diamonds"));
        deck.add(new Card ("7", "Diamonds"));
        deck.add(new Card ("8", "Diamonds"));
        deck.add(new Card ("9", "Diamonds"));
        deck.add(new Card ("10", "Diamonds"));
        deck.add(new Card ("J", "Diamonds"));
        deck.add(new Card ("Q", "Diamonds"));
        deck.add(new Card ("K", "Diamonds"));
        deck.add(new Card ("A", "Diamonds"));

        deck.add(new Card ("2", "Clubs"));
        deck.add(new Card ("3", "Clubs"));
        deck.add(new Card ("4", "Clubs"));
        deck.add(new Card ("5", "Clubs"));
        deck.add(new Card ("6", "Clubs"));
        deck.add(new Card ("7", "Clubs"));
        deck.add(new Card ("8", "Clubs"));
        deck.add(new Card ("9", "Clubs"));
        deck.add(new Card ("10", "Clubs"));
        deck.add(new Card ("J", "Clubs"));
        deck.add(new Card ("Q", "Clubs"));
        deck.add(new Card ("K", "Clubs"));
        deck.add(new Card ("A", "Clubs"));
    }

    public ArrayList<Card> getDeck(){
        return deck;
    }

    public Card getCard(){
        Card card = deck.get((int) (Math.random() * deck.size()));
        deck.remove(card);
        return card;
    }

    public void shuffleCards(){
        //shuffle 52 cards
        for (int i = 0; i < 52; i++) {
            int r = (int) Math.floor((Math.random() * 52));
            //swapping cards
            Card temp = deck.get(r);
            deck.set(r, deck.get(i));
            deck.set(i, temp);
        }
    }

}

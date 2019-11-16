package com.company;

/**
 * @author: Marcelo Mariduena
 */

public class Card {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }
    public String getSuit() {
        return suit;
    }

    public void setCard(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public void setRank(String rank){
        this.rank = rank;
    }
    public void setSuit(String suit){
        this.suit = suit;
    }
    public String toString() { return rank + " of " + suit; }
}

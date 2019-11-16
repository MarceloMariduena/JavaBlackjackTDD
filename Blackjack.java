package com.company;

/**
 * @author: Marcelo Mariduena
 */

import java.util.ArrayList;

public class Blackjack {

    private Deck deck;
    private ArrayList<Card> player;
    private ArrayList<Card> dealer;

    public Blackjack(){
        deck = new Deck();
        player = new ArrayList<Card>();
        dealer = new ArrayList<Card>();
    }

    public Deck getDeck() {
        return deck;
    }

    public ArrayList<Card> getDealer() {
        return dealer;
    }

    public ArrayList<Card> getPlayer() {
        return player;
    }

    public String dealCardsToDealer(){
        if(dealer.isEmpty()){
            dealer.add(deck.getCard());
            dealer.add(deck.getCard());

            if(dealer.get(0).getRank().equals("A") || dealer.get(0).getRank().equals("K"))
                dealerPeek();
            return "The dealer did not need to peek.";
        }

        else
            return "The dealer has already been dealt a hand.";
    }

    public String dealerPeek() {
        if(dealer.get(0).getRank().equals("A"))
            if(dealer.get(1).getRank().equals("K"))
                return "The dealer peeks and has a blackjack. You lose.";
            else
                return "The dealer peeks and does not have a blackjack.";

        else if(dealer.get(0).getRank().equals("K"))
            if(dealer.get(1).getRank().equals("A"))
                return "The dealer peeks and has a blackjack. You lose.";
            else
                return "The dealer peeks and does not have a blackjack.";

        else
            return "The dealer peeks and does not have a blackjack.";
    }

    public String dealCardsToPlayer(){
        if(player.isEmpty()) {
            player.add(deck.getCard());
            player.add(deck.getCard());
            if((player.get(0).equals("A") && player.get(1).equals("K"))
                    || (player.get(0).equals("K") && player.get(1).equals("A"))){
                return "Lucky! You were dealt a blackjack! You win!";
            }
            else {
                return "You were not dealt a blackjack.";
            }
        }
        else
            return "Player has already been dealt a hand.";
    }

    public int calculateHand(ArrayList<Card> hand){
        if(hand.isEmpty())
            return -1;

        int count = 0;
        for(Card card : hand){
            switch(card.getRank()){
                case "A": count += 11; break;
                case "J": count += 10; break;
                case "Q": count += 10; break;
                case "K": count += 10; break;
                default: count += Integer.parseInt(card.getRank());
            }
        }
        return count;
    }
}

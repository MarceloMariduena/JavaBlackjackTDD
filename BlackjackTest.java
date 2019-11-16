package com.company;

/**
 * @author: Marcelo Mariduena
 */

/*  TDD Best Practices:
    1. Write the test
    2. Run the test (there is no implementation code, test does not pass)
    3. Write just enough implementation code to make the test pass
    4. Run all tests (tests pass)
    5. Refactor
    6. Repeat
 */

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BlackjackTest {
    private Blackjack ourGame;
    private Deck deck;

    /* SETUP */
    @Before
    public void Setup(){
        ourGame = new Blackjack();
        deck = new Deck();
    }

    @Test
    public void testDeck(){
        //Deck exists and has proper amount of cards.
        Assert.assertNotNull(ourGame.getDeck());
        Assert.assertTrue(ourGame.getDeck().getDeck().size() == 52);

        //Cards can be drawn from the deck.
        Card firstCardDrawn = ourGame.getDeck().getCard();
        Assert.assertTrue(ourGame.getDeck().getDeck().size() == 51);
        Assert.assertFalse((ourGame.getDeck().getDeck().contains(firstCardDrawn)));

        Card secondCardDrawn = ourGame.getDeck().getCard();
        Assert.assertTrue(ourGame.getDeck().getDeck().size() == 50);
        Assert.assertFalse((ourGame.getDeck().getDeck().contains(secondCardDrawn)));

        // Each drawn card is different.
        Assert.assertNotEquals(firstCardDrawn, secondCardDrawn);
    }

    @Test
    public void testGetDeck(){
        //Deck has proper cards
        for(int i = 0; i < 52; i++){
            Assert.assertTrue(deck.getDeck().get(i).toString().equals(
                    ourGame.getDeck().getDeck().get(i).toString()
            ));
        }
    }

    @Test
    public void testGetCard(){
        //Different cards are drawn.
        Assert.assertFalse(ourGame.getDeck().getCard().equals(ourGame.getDeck().getCard()));
    }

    @Test
    public void testPlayer(){
        //Player and dealer exist after instantiation
        Assert.assertNotNull(ourGame.getPlayer());
        Assert.assertNotNull(ourGame.getDealer());
    }

    @Test
    public void testDealCardsToDealer(){
        //Dealer is dealt a hand (2 cards)
        Assert.assertTrue(ourGame.getDealer().isEmpty());
        ourGame.dealCardsToDealer();
        Assert.assertFalse(ourGame.getDealer().isEmpty());

        //test boundaries: ensure dealer cannot be dealt more than 2 cards
        Assert.assertEquals("The dealer has already been dealt a hand.", ourGame.dealCardsToDealer());
    }

    @Test
    public void testDealerPeek(){
        //Dealer peek is working
        ourGame.dealCardsToDealer();
        ourGame.getDealer().set(0, new Card("K", "Hearts"));
        ourGame.getDealer().set(1, new Card("A", "Hearts"));
        Assert.assertEquals("The dealer peeks and has a blackjack. You lose.", ourGame.dealerPeek());

        ourGame.getDealer().set(0, new Card("A", "Hearts"));
        ourGame.getDealer().set(1, new Card("K", "Hearts"));
        Assert.assertEquals("The dealer peeks and has a blackjack. You lose.", ourGame.dealerPeek());

        ourGame.getDealer().set(0, new Card("A", "Hearts"));
        ourGame.getDealer().set(1, new Card("3", "Hearts"));
        Assert.assertEquals("The dealer peeks and does not have a blackjack.", ourGame.dealerPeek());
    }

    @Test
    public void testDealCardsToPlayer(){
        //Player is dealt a hand (2 cards)
        Assert.assertTrue(ourGame.getPlayer().isEmpty());

        ourGame.dealCardsToPlayer();
        Assert.assertFalse(ourGame.getPlayer().isEmpty());

        //test boundaries: ensure player cannot be dealt more than 2 cards at the beginning of the game
        Assert.assertEquals("Player has already been dealt a hand.", ourGame.dealCardsToPlayer());
        Assert.assertTrue(ourGame.getPlayer().size() == 2);
    }

    @Test
    public void testCalculateHand(){
        //Initial hand is empty until dealt cards.
        Assert.assertTrue(ourGame.calculateHand(ourGame.getPlayer()) == -1);

        //Hand count is properly calculated
        ourGame.dealCardsToPlayer();
        int firstCard = Integer.parseInt(ourGame.getPlayer().get(0).getRank());
        int secondCard = Integer.parseInt(ourGame.getPlayer().get(1).getRank());
        int expectedCount = firstCard + secondCard;

        Assert.assertEquals(expectedCount, ourGame.calculateHand(ourGame.getPlayer()));
    }

}

package inf112.skeleton.app;

import inf112.skeleton.app.cards.Deck;
import inf112.skeleton.app.cards.MoveCard;
import inf112.skeleton.app.cards.RotateCard;
import inf112.skeleton.app.interfaces.ICard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

class DeckTest {
    private Deck testDeck;
    private int DECK_SIZE;

    @BeforeEach
    public void initiate(){
        this.testDeck = new Deck();
        this.DECK_SIZE = testDeck.DECK_SIZE;
    }

    @Test
    @DisplayName("Get 9 cards from deck test")
    public void getCardsFromDeckTest(){
        ArrayList<ICard> retrievedCards = testDeck.getCards(9);
        assert !retrievedCards.isEmpty();
        assertEquals(9,retrievedCards.size());
    }

    @Test
    @DisplayName("Get all cards from deck")
    public void getAllCardsTest() {
        LinkedList<ICard> retrievedCards = testDeck.peekAllCards();
        assertEquals(DECK_SIZE,retrievedCards.size());
    }
    
    /*
    @Test
    @DisplayName("Get more cards than deck size test")
    public void getMoreCardsThanDeckSizeTest(){
        ArrayList<ICard> retrievedCards = testDeck.getCards(100);
        assertEquals(DECK_SIZE,retrievedCards.size());
        assert testDeck.peekAllCards().isEmpty(); // Check if deck is empty after operation
    }
    */
    
    @Test
    @DisplayName("Add card to deck test")
    public void addCardToDeckTest(){
        testDeck.getCards(20); // Removes 20 cards
        MoveCard test = new MoveCard(1,100,"TestCard",null);
        testDeck.addCard(test); // Adds card at the bottom
        assertEquals(testDeck.peekAllCards().get(0),test);
    }

    @Test
    @DisplayName("Add card to full deck test")
    public void addCardToFullDeckTest(){
        boolean error = false;
        try {
            testDeck.addCard(new MoveCard(1,100,"TestCard",null));
        } catch (IllegalArgumentException e){
            error = true;
        }
        assertTrue(error);
    }

    @Test
    @DisplayName("Test if the correct amount of each type of card")
    public void testIfCorrectCardsAreInDeck(){
        int rotateCards = 0;
        int TARGET_ROTATE_CARDS = 42;
        int moveCards = 0;
        int TARGET_MOVE_CARDS = 42;
        for(ICard card : testDeck.peekAllCards()){
            if(card instanceof RotateCard){
                rotateCards++;
            } else if (card instanceof MoveCard){
                moveCards++;
            }
        }
        assertEquals(rotateCards,TARGET_ROTATE_CARDS);
        assertEquals(moveCards,TARGET_MOVE_CARDS);
    }
}

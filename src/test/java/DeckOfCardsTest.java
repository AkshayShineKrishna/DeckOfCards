import com.demo.models.Cards;
import com.demo.models.Rank;
import com.demo.models.Suit;
import com.demo.services.Deck;
import org.junit.jupiter.api.Test;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class DeckOfCardsTest {
    @Test
    void deckShouldHave52Cards() {
        Deck deck = new Deck();
        assertEquals(52, deck.getCards().size());
    }

    @Test
    void deckShouldHaveUniqueCards() {
        Deck deck = new Deck();
        Set<Cards> cards = new HashSet<>();

        for (int i = 0; i < 52; i++) {
            cards.add(deck.drawCard());
        }
        assertEquals(52, cards.size());
    }

    @Test
    void cardsShouldSortBySuitThenRank() {
        Cards card1 = new Cards(Suit.HEARTS, Rank.KING);
        Cards card2 = new Cards(Suit.HEARTS, Rank.TWO);
        Cards card3 = new Cards(Suit.SPADES, Rank.ACE);
        List<Cards> cards = Arrays.asList(card1, card2, card3);

        cards.sort((c1, c2) ->
                c1.getSuit().equals(c2.getSuit())
                        ? c1.getRank().compareTo(c2.getRank())
                        : c1.getSuit().compareTo(c2.getSuit()));

        assertEquals(card2, cards.get(0)); // TWO OF HEARTS
        assertEquals(card1, cards.get(1)); // KING OF HEARTS
        assertEquals(card3, cards.get(2)); // ACE OF SPADES
    }

    @Test
    void drawCardShouldThrowExceptionWhenDeckIsEmpty() {
        Deck deck = new Deck();
        for (int i = 0; i < 52; i++) {
            deck.drawCard();
        }
        assertThrows(NoSuchElementException.class, () -> deck.drawCard());
    }

    @Test
    void shuffleShouldChangeCardOrderMostOfTheTime() {
        Deck deck = new Deck();

        List<Cards> originalOrder = new ArrayList<>(deck.getCards());

        boolean changed = false;
        for (int i = 0; i < 5; i++) {
            deck.shuffle();
            if (!originalOrder.equals(deck.getCards())) {
                changed = true;
                break;
            }
        }

        assertTrue(changed, "Shuffle did not change card order after multiple attempts");
    }
}

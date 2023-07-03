package blackjack.domain;

import java.util.*;

public class Deck {

    private final LinkedList<Card> cards;

    public Deck() {
        cards = new LinkedList<>();
        setupCard();
        shuffle();
    }

    private void setupCard() {
        for (Suit suit : Suit.values()) {
            setTrump(suit);
        }
    }

    private void setTrump(Suit suit) {
        for (Trump trump : Trump.values()) {
            cards.add(new Card(suit, trump));
        }
    }

    private void shuffle() {
        Collections.shuffle(cards);
    }

    public Card popCard() {
        Card popped = cards.remove(0);
        return new Card(popped.getSuit(), popped.getTrump());
    }

}
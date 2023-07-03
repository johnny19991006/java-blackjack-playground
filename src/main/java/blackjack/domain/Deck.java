package blackjack.domain;

import java.util.*;

public class Deck {

    private final ArrayDeque<Card> cards;

    public Deck() {
        cards = new ArrayDeque<>();
        setupCard();
        shuffle();
    }

    private void setupCard() {
        for (Suit suit : EnumSet.allOf(Suit.class)) {
            setTrump(suit);
        }
    }

    private void setTrump(Suit suit) {
        for (Trump trump : EnumSet.allOf(Trump.class)) {
            cards.add(new Card(suit, trump));
        }
    }

    private void shuffle() {
        Collections.shuffle(new ArrayList<>(cards));
    }

    public Card popCard() {
        return cards.pollFirst();
    }
}
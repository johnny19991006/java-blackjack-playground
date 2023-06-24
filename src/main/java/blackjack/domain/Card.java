package blackjack.domain;

public class Card {

    private final Suit suit;
    private final Trump trump;

    public Card(Suit suit, Trump trump) {
        this.suit = suit;
        this.trump = trump;
    }

    public Suit getSuit() {
        return suit;
    }

    public Trump getTrump() {
        return trump;
    }

    public String getTrumpCardName() {
        return trump.getCardName();
    }

    public String getSuitName() {
        return suit.getName();
    }

}
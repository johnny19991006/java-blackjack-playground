package blackjack.domain;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private static final int TEN = 10;
    private static final int VINGT_ET_UN = 21;

    protected String name;
    protected List<Card> cards;

    public Player(final String name) {
        this.name = name;
        this.cards = new ArrayList<>();
    }

    public int calculateScore() {
        int score = cards.stream().mapToInt(card -> card.getTrump().getScore()).sum();
        long aceCount = cards.stream().filter(card -> card.getTrump().isAce()).count();
        for (int i = 0; i < aceCount; i++) {
            score = adjustScore(score);
        }
        return score;
    }

    public int adjustScore(int score) {
        if (score + TEN <= VINGT_ET_UN) {
            score += TEN;
        }
        return score;
    }

    public void receiveCard(Card card) {
        cards.add(card);
    }

    public String getName() {
        return name;
    }

    public List<Card> getCards() {
        return cards;
    }

}
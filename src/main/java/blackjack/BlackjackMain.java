package blackjack;

import blackjack.controller.BlackjackController;

public class BlackjackMain {

    public static void main(String[] args) {
        BlackjackController blackjackGame = new BlackjackController();
        blackjackGame.play();
    }
}
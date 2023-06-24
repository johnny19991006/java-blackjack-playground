package blackjack.utils;

public enum OutputMessage {
    DEALER_RECEIVED_ONE_MORE_CARD("딜러는 16이하라 한장의 카드를 더 받았습니다."),
    GIVE_DEALER_PLAYER_TWO_CARD("에게 2장의 카드를 나누어 주었습니다");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

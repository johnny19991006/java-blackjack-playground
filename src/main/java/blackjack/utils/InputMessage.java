package blackjack.utils;

public enum InputMessage {
    GET_USER_NAMES_MESSAGE("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)"),
    ASK_PLAYER_TO_ADD_CARD("은(는) 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)"),
    ANSWER_ERROR_MESSAGE("잘못된 입력입니다. y 또는 n을 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}

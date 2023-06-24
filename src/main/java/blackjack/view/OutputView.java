package blackjack.view;

import blackjack.domain.Player;
import blackjack.utils.OutputMessage;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final String DEALER = "딜러와 ";
    private static final String CARD = "카드: ";
    private static final String RESULT_DELIMITER = " - 결과: ";
    private static final String FINAL_RESULT = "## 최종 승패";
    private static final String COLON = ": ";

    public static void printInitialCardDistribute(List<String> players) {

        System.out.println(DEALER + players + OutputMessage.GIVE_DEALER_PLAYER_TWO_CARD.getMessage());
    }

    public static void printPlayersCard(List<Player> players) {
        players.forEach(player -> {
            printJoinedCardInfo(player);
            System.out.println();
        });
        System.out.println();
    }

    public static void printJoinedCardInfo(Player player) {
        List<String> cardsInfo = player.getCards().stream()
                .map(card -> card.getTrumpCardName() + card.getSuitName())
                .collect(Collectors.toList());
        System.out.print(player.getName() + CARD + String.join(", ", cardsInfo));
    }

    public static void printDealerReceived() {
        System.out.println(OutputMessage.DEALER_RECEIVED_ONE_MORE_CARD.getMessage());
    }

    public static void printGameResult(List<Player> players, Map<String, String> results) {
        players.forEach(player -> {
            printJoinedCardInfo(player);
            System.out.println(RESULT_DELIMITER + player.calculateScore());
        });
        System.out.println();
        printFinalResult(results);
    }

    private static void printFinalResult(Map<String, String> results) {
        System.out.println(FINAL_RESULT);
        results.forEach((name, result) -> {
            System.out.println(name + COLON + result);
        });
    }

}
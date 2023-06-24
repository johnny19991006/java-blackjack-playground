package blackjack.view;

import blackjack.domain.Player;
import blackjack.utils.InputMessage;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static String YES = "y";
    private static String NO = "n";

    public static List<String> getPlayersName() {
        Scanner SCANNER = new Scanner(System.in);
        System.out.println(InputMessage.GET_USER_NAMES_MESSAGE.getMessage());
        String[] parsedInput = SCANNER.nextLine().split(",");
        Stream<String> players = Arrays.stream(parsedInput).map(String::trim);
        return players.collect(Collectors.toList());
    }

    public static boolean askAddCard(Player player) {
        Scanner SCANNER = new Scanner(System.in);
        System.out.println(player.getName() + InputMessage.ASK_PLAYER_TO_ADD_CARD.getMessage());
        String answer = SCANNER.nextLine();
        if (YES.equals(answer)) {
            return true;
        }
        if (NO.equals(answer)) {
            return false;
        }
        throw new RuntimeException(InputMessage.ANSWER_ERROR_MESSAGE.getMessage());
    }

}
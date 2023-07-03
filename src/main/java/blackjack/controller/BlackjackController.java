package blackjack.controller;

import blackjack.domain.Dealer;
import blackjack.domain.Judgement;
import blackjack.domain.Player;
import blackjack.domain.Players;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BlackjackController {

    public void play() {
        List<String> playersName = getPlayerName();
        Dealer dealer = new Dealer();
        Players players = Players.create(playersName);
        List<Player> allGamblers = getAllGamblers(dealer, players);
        allGamblers.forEach(dealer::allocateInitialCards);
        OutputView.printPlayersCard(allGamblers);

        betting(dealer, players);

        checkIfDealerGotMoreCard(dealer);

        Judgement judgement = new Judgement(allGamblers);
        OutputView.printGameResult(allGamblers, judgement.findWinners());
    }

    private void betting(Dealer dealer, Players players) {
        boolean isPlaying;
        do {
            isPlaying = false;
            for (Player player : players.getPlayers()) {
                isPlaying |= isPlayerGettingMoreCard(dealer, player);
            }
            players.filterBustedPlayers();
        } while (isPlaying);
    }

    private boolean isPlayerGettingMoreCard(Dealer dealer, Player player) {
        boolean answer = InputView.askAddCard(player);
        if (answer) {
            dealer.allocateCard(player);
            OutputView.printJoinedCardInfo(player);
            System.out.println();
            return true;
        }
        return false;
    }

    private List<String> getPlayerName() {
        List<String> playersName = InputView.getPlayersName();
        OutputView.printInitialCardDistribute(playersName);
        return playersName;
    }

    private void checkIfDealerGotMoreCard(Dealer dealer) {
        if (dealer.addOneMoreCard()) {
            OutputView.printDealerReceived();
        }
    }

    private List<Player> getAllGamblers(Dealer dealer, Players players) {
        List<Player> allGamblers = new ArrayList<>();
        allGamblers.add(dealer);
        allGamblers.addAll(players.getPlayers());
        return allGamblers;
    }
}

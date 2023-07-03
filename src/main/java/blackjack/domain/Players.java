package blackjack.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Players {

    private final List<Player> players;
    private static final int VINGT_ET_UN = 21;

    private Players(List<Player> players) {
        this.players = players;
    }

    public static Players create(List<String> playerNames) {
        List<Player> players = new ArrayList<>();
        for (String playerName : playerNames) {
            players.add(new Player(playerName));
        }
        return new Players(players);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void filterBustedPlayers() {
        players.removeIf(player -> player.calculateScore() > VINGT_ET_UN);
    }
}


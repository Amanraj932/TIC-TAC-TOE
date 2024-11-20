package model;

import java.sql.Timestamp;

public class GameResult {
    private String player1;
    private String player2;
    private String winner;
    private Timestamp datePlayed;

    public GameResult(String player1, String player2, String winner, Timestamp datePlayed) {
        this.player1 = player1;
        this.player2 = player2;
        this.winner = winner;
        this.datePlayed = datePlayed;
    }

    public GameResult(String player1, String player2, String winner) {
        this(player1, player2, winner, new Timestamp(System.currentTimeMillis()));
    }

    public String getPlayer1() { return player1; }
    public String getPlayer2() { return player2; }
    public String getWinner() { return winner; }
    public Timestamp getDatePlayed() { return datePlayed; }
}
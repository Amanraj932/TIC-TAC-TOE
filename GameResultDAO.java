package dao;

import model.GameResult;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameResultDAO {
    private final String dbUrl = "jdbc:sqlite:db/tic_tac_toe.db";

    public GameResultDAO() {
        try (Connection conn = DriverManager.getConnection(dbUrl)) {
            // Test connection
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveGameResult(GameResult result) {
        String query = "INSERT INTO game_results (player1, player2, winner) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(dbUrl);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, result.getPlayer1());
            stmt.setString(2, result.getPlayer2());
            stmt.setString(3, result.getWinner());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<GameResult> getAllResults() {
        List<GameResult> results = new ArrayList<>();
        String query = "SELECT * FROM game_results";
        try (Connection conn = DriverManager.getConnection(dbUrl);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                results.add(new GameResult(
                        rs.getString("player1"),
                        rs.getString("player2"),
                        rs.getString("winner"),
                        rs.getTimestamp("date_played")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
}
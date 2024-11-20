package servlet;

import dao.GameResultDAO;
import model.GameResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/tic-tac-toe")
public class TicTacToeServlet extends HttpServlet {
    private GameResultDAO dao;

    @Override
    public void init() throws ServletException {
        dao = new GameResultDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>Tic Tac Toe Game</h1>");
        resp.getWriter().println("<p>Play and view results.</p>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String player1 = req.getParameter("player1");
        String player2 = req.getParameter("player2");
        String winner = req.getParameter("winner");

        if (player1 != null && player2 != null && winner != null) {
            GameResult result = new GameResult(player1, player2, winner);
            dao.saveGameResult(result);
            resp.getWriter().println("Game result saved!");
        } else {
            resp.getWriter().println("Missing parameters!");
        }
    }
}
-- Create a SQLite database to store game results
CREATE TABLE IF NOT EXISTS game_results (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    player1 VARCHAR(50),
    player2 VARCHAR(50),
    winner VARCHAR(50),
    date_played TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
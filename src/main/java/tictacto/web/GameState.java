package tictacto.web;

public class GameState {
    private String[][] board = new String[3][3];
    private String currentPlayer = "X";
    private boolean gameEnded = false;
    private String winner = null;
    // constructors, getters, setters

    public synchronized boolean makeMove(int x, int y, String player) {
        if (gameEnded || board[x][y] != null || !player.equals(currentPlayer)) {
            return false;
        }
        board[x][y] = player;
        if (checkWin(player)) {
            gameEnded = true;
            winner = player;
        } else if (checkDraw()) {
            gameEnded = true;
        } else {
            currentPlayer = currentPlayer.equals("X") ? "O" : "X";
        }
        return true;
    }

    private boolean checkWin(String player) {
        // Check rows, columns, diagonals
        for (int i = 0; i < 3; i++) {
            if (player.equals(board[i][0]) && player.equals(board[i][1]) && player.equals(board[i][2])) return true;
            if (player.equals(board[0][i]) && player.equals(board[1][i]) && player.equals(board[2][i])) return true;
        }
        if (player.equals(board[0][0]) && player.equals(board[1][1]) && player.equals(board[2][2])) return true;
        if (player.equals(board[0][2]) && player.equals(board[1][1]) && player.equals(board[2][0])) return true;
        return false;
    }

    private boolean checkDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j] == null)
                    return false;
        return true;
    }
}

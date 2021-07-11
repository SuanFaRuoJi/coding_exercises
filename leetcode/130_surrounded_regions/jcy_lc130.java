public class jcy_lc130 {
    public void solve(char[][] board) {
        if (board.length == 0) return;
        int rows = board.length, cols = board[0].length;
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') dfs(i, 1, board);
            if (board[i][cols - 1] == 'O') dfs(i, cols - 2, board);
        }
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O') dfs(1, i, board);
            if (board[rows - 1][i] == 'O') dfs(rows - 2, i, board);
        }
        for (int i = 1; i < rows - 1; i++) {
            for (int j = 1; j < cols - 1; j++) {
                if (board[i][j] == '*') board[i][j] = 'O';
                else if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }

    }

    private void dfs(int i, int j, char[][] board) {
        int rows = board.length, cols = board[0].length;
        if (i <= 0 || i >= rows - 1 || j <= 0 || j >= cols - 1 || board[i][j] == 'X') return;
        else if (board[i][j] == '*') return;
        else if (board[i][j] == 'O') board[i][j] = '*';
        dfs(i + 1, j, board);
        dfs(i - 1, j, board);
        dfs(i, j + 1, board);
        dfs(i, j - 1, board);
    }
}
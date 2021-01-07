public class jcy_lc529_dfs {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1], m = board.length, n = board[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
        if (board[x][y] == 'M') board[x][y] = 'X';
        else dfs(board, x, y, dirs);
        return board;
    }

    private void dfs(char[][] board, int x, int y, int[][] dirs) {
        int m = board.length, n = board[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'E') return;
        int count = 0;
        for (int[] d : dirs) {
            int r = x + d[0], c = y + d[1];
            if (r < 0 || r >= m || c < 0 || c >= n) continue;
            if (board[r][c] == 'M') count += 1;
        }
        if (count > 0) board[x][y] = (char)('0' + count);
        else {
            board[x][y] = 'B';
            for (int[] d : dirs) dfs(board, x + d[0], y + d[1], dirs);
        }
    }
}
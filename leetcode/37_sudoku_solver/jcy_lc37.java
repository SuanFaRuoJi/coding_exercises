public class jcy_lc37 {
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }

    private boolean helper(char[][] board, int row, int col) {
        for (int i = row; i < 9; i++, col = 0) {
            for (int j = col; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;
                            if (helper(board, i, j + 1)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c) {
        int regionRow = 3 * (row / 3), regionCol = 3 * (col / 3);
        for (int i = 0; i < 9; i++)
            if (board[i][col] == c || board[row][i] == c || board[regionRow + i / 3][regionCol + i % 3] == c) return false;
        return true;
    }
}
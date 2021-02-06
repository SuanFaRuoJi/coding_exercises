import java.util.ArrayList;
import java.util.List;

public class jcy_lc51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        helper(res, board, 0);
        return res;
    }

    private void helper(List<List<String>> res, char[][] board, int row) {
        if (row == board.length) {
            res.add(construct(board));
            return;
        }
        for (int col = 0; col < board.length; col++) {
            if (valid(board, row, col)) {
                board[row][col] = 'Q';
                helper(res, board, row + 1);
                board[row][col] = '.';
            }
        }
    }

    private boolean valid(char[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            int n = board.length;
            if (board[i][col] == 'Q') return false;
            int rowDiff = row - i;
            if (col + rowDiff < n && board[i][col + rowDiff] == 'Q') return false;
            if (col - rowDiff >= 0 && board[i][col - rowDiff] == 'Q') return false;
        }
        return true;
    }

    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) res.add(new String(board[i]));
        return res;
    }
}
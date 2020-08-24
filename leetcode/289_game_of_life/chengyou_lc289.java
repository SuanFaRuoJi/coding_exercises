public class chengyou_lc289 {
    public void gameOfLife(int[][] board) {
        int[] neighbors = {0, 1, -1};
        int rows = board.length, cols = board[0].length;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int liveNeighbors = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
                            int r = row + neighbors[i];
                            int c = col + neighbors[j];
                            if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1))
                                liveNeighbors += 1;
                        }
                    }
                }
                if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3))
                    board[row][col] = -1;
                if (board[row][col] == 0 && liveNeighbors == 3)
                    board[row][col] = 2;
            }
        }
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] > 0) board[r][c] = 1;
                else board[r][c] = 0;
            }
        }
    }
}

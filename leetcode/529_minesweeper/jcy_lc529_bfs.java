import java.util.LinkedList;
import java.util.Queue;

public class jcy_lc529_bfs {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        int m = board.length, n = board[0].length;
        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(click);
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1], count = 0;
            for (int[] d : dir) {
                int r = x + d[0], c = y + d[1];
                if (r < 0 || r >= m || c < 0 || c >= n) continue;
                if (board[r][c] == 'M') count += 1;
            }
            if (count > 0) board[x][y] = (char)(count + '0');
            else {
                board[x][y] = 'B';
                for (int[] d : dir) {
                    int r = x + d[0], c = y + d[1];
                    if (r < 0 || r >= m || c < 0 || c >= n) continue;
                    if (board[r][c] == 'E') {
                        queue.add(new int[]{r, c});
                        board[r][c] = 'B';
                    }
                }
            }
        }
        return board;
    }
}
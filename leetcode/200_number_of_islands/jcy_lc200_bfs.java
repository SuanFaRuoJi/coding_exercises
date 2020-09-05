import java.util.LinkedList;
import java.util.Queue;

public class jcy_lc200_bfs {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length, col = grid[0].length, res = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    res += 1;
                    grid[i][j] = '0';
                    Queue<int[]> neighbors = new LinkedList<>();
                    neighbors.add(new int[]{i, j});
                    while (!neighbors.isEmpty()) {
                        int[] position = neighbors.poll();
                        int r = position[0], c = position[1];
                        if (r - 1 >= 0 && grid[r - 1][c] == '1') {
                            neighbors.add(new int[]{r - 1, c});
                            grid[r - 1][c] = '0';
                        }
                        if (r + 1 < row && grid[r + 1][c] == '1') {
                            neighbors.add(new int[]{r + 1, c});
                            grid[r + 1][c] = '0';
                        }
                        if (c - 1 >= 0 && grid[r][c - 1] == '1') {
                            neighbors.add(new int[]{r, c - 1});
                            grid[r][c - 1] = '0';
                        }
                        if (c + 1 < col && grid[r][c + 1] == '1') {
                            neighbors.add(new int[]{r, c + 1});
                            grid[r][c + 1] = '0';
                        }
                    }
                }
            }
        }
        return res;
    }
}
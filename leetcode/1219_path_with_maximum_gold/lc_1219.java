import java.util.ArrayList;
import java.util.List;

public class lc_1219 {
    private int max = Integer.MIN_VALUE;
    public int getMaximumGold(int[][] grid) {
        int height = grid.length, width;
        if (height == 0) {
            return 0;
        }
        width = grid[0].length;
        List<int[]> endpoints = new ArrayList<>();
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int edges = 0;
                if (i-1>=0 && grid[i][j]!=0) {
                    edges++;
                }
                if (i+1<height && grid[i][j]!=0) {
                    edges++;
                }
                if (j-1>=0 && grid[i][j]!=0) {
                    edges++;
                }
                if (j+1<width && grid[i][j]!=0) {
                    edges++;
                }
                if (edges <= 1) {
                    int[] to_add = {i, j};
                    endpoints.add(to_add);
                }
            }
        }
        int[][] cross = new int[height][width];
        for (int[] point : endpoints) {
            search(grid, cross, point[0], point[1], 0);
        }
        return max;
    }

    private void search(int[][] grid, int[][] cross, int i, int j, int sum) {
        sum += grid[i][j];
        if (sum > max) {
            max = sum;
        }
        int next_i, next_j;
        next_i = i-1;
        next_j = j;
        if (next_i>=0 && grid[next_i][next_j]!=0 && cross[next_i][next_j]!=0) { // left
            cross[next_i][next_j] = 1;
            search(grid, cross, next_i, next_j, sum);
            cross[next_i][next_j] = 0;
        }

        next_i = i+1;
        next_j = j;
        if (next_i<grid.length && grid[next_i][next_j]!=0 && cross[next_i][next_j]!=0) { // left
            cross[next_i][next_j] = 1;
            search(grid, cross, next_i, next_j, sum);
            cross[next_i][next_j] = 0;
        }

        next_i = i;
        next_j = j-1;
        if (next_j>=0 && grid[next_i][next_j]!=0 && cross[next_i][next_j]!=0) { // left
            cross[next_i][next_j] = 1;
            search(grid, cross, next_i, next_j, sum);
            cross[next_i][next_j] = 0;
        }

        next_i = i;
        next_j = j+1;
        if (next_j<=grid[0].length && grid[next_i][next_j]!=0 && cross[next_i][next_j]!=0) { // left
            cross[next_i][next_j] = 1;
            search(grid, cross, next_i, next_j, sum);
            cross[next_i][next_j] = 0;
        }
    }
}

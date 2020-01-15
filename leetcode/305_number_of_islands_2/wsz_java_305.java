import java.util.ArrayList;
import java.util.List;

public class wsz_java_305 {
    private int num = 0, height, width;
    private int[][] uptree, map;

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        uptree = new int[m][n];
        map = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                uptree[i][j] = -1; // default value
            }
        }
        height = m;
        width = n;
        for (int[] coor: positions) {
            int x = coor[0], y = coor[1];
            map[x][y] = 1; // seed the island;
            num ++;
            if (x-1 >= 0) {
                if (map[x-1][y] != 0) { // is an island
                    union(x, y, x-1, y);
                }
            }
            if (x+1 < m) {
                if (map[x+1][y] != 0) {
                    union(x, y, x+1, y);
                }
            }
            if (y-1 >= 0) {
                if (map[x][y-1] != 0) {
                    union(x, y, x, y-1);
                }
            }
            if (y+1 < n) {
                if (map[x][y+1] != 0) {
                    union(x, y, x, y+1);
                }
            }
            result.add(num);
        }
        return result;
    }

    private int[] find(int x, int y) { // path compression
        int cur_x = x, cur_y = y;
        int val = uptree[cur_x][cur_y];
        while (val != -1) {
            int[] coor = convert(val);
            cur_x = coor[0];
            cur_y = coor[1];
            val = uptree[cur_x][cur_y];
        }
        if (!(cur_x == x && cur_y == y)) {
            uptree[x][y] = convert(cur_x, cur_y);
        }
        int[] result = {cur_x, cur_y};
        return result;
    }

    private void union(int x1, int y1, int x2, int y2) { // by rank
        int[] root1 = find(x1, y1), root2 = find(x2, y2);
        int weight1 = map[root1[0]][root1[1]], weight2 = map[root2[0]][root2[1]];
        if (weight1 >= weight2) {
            uptree[root2[0]][root2[1]] = convert(root1[0], root1[1]);
            map[root1[0]][root1[1]] += weight2;
        } else {
            uptree[root1[0]][root1[1]] = convert(root2[0], root2[1]);
            map[root2[0]][root2[1]] += weight1;
        }
        num --;
    }

    private int[] convert(int val) {
        int[] result = {val / width, val % width};
        return result;
    }

    private int convert(int x, int y) {
        return x * width + y;
    }
}

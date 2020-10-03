public class jcy_lc265_2 {
    public int minCostII(int[][] costs) {
        if (costs.length == 0) return 0;
        int n = costs.length, color = costs[0].length;
        for (int i = n - 2; i >= 0; i--) {
            int minCol = -1, secMin = -1;
            for (int j = 0; j < color; j++) {
                int curr = costs[i + 1][j];
                if (minCol == -1 || curr < costs[i + 1][minCol]) {
                    secMin = minCol;
                    minCol = j;
                } else if (secMin == -1 || curr < costs[i + 1][secMin])
                    secMin = j;
            }
            for (int j = 0; j < color; j++) {
                if (j == minCol) costs[i][j] += costs[i + 1][secMin];
                else costs[i][j] += costs[i + 1][minCol];
            }
        }
        int res = Integer.MAX_VALUE;
        for (int cost : costs[0])
            res = Math.min(res, cost);
        return res;
    }
}
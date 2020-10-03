public class jcy_lc265 {
    public int minCostII(int[][] costs) {
        if (costs.length == 0) return 0;
        int n = costs.length, color = costs[0].length;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < color; j++) {
                int minCost = Integer.MAX_VALUE;
                for (int k = 0; k < color; k++) {
                    if (j == k) continue;
                    minCost = Math.min(minCost, costs[i + 1][k]);
                }
                costs[i][j] += minCost;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int cost : costs[0])
            res = Math.min(res, cost);
        return res;
    }
}
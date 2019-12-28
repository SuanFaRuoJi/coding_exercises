public class wsz_java_265 {
    public int minCostII(int[][] costs) {
        int l_house = costs.length, l_paint;
        if (l_house == 0) {
            return 0;
        } else {
            l_paint = costs[0].length;
        }
        int[][][] dp = new int[l_house][l_paint][2];
        int min_1 = Integer.MAX_VALUE, min_1_arg = -1, min_2 = Integer.MAX_VALUE;
        for (int i=0; i<l_paint; i++) { // first house [use i]
            dp[0][i][0] = costs[0][i];
            if (costs[0][i] < min_1) {
                min_2 = min_1;
                min_1_arg = i;
                min_1 = costs[0][i];
            } else {
                if (costs[0][i] < min_2) {
                    min_2 = costs[0][i];
                }
            }
        }
        for (int i=0; i<l_paint; i++) {
            if (i != min_1_arg) {
                dp[0][i][1] = min_1;
            } else {
                dp[0][i][1] = min_2;
            }
        }
        for (int i=1; i<l_house; i++) {
            min_1 = Integer.MAX_VALUE; min_1_arg = -1; min_2 = Integer.MAX_VALUE;
            for (int j=0; j<l_paint; j++) {
                dp[i][j][0] = costs[i][j] + dp[i-1][j][1];
                if (dp[i][j][0] < min_1) {
                    min_2 = min_1;
                    min_1_arg = j;
                    min_1 = dp[i][j][0];
                } else {
                    if (dp[i][j][0] < min_2) {
                        min_2 = dp[i][j][0];
                    }
                }
            }
            for (int j=0; j<l_paint; j++) {
                if (j != min_1_arg) {
                    dp[i][j][1] = min_1;
                } else {
                    dp[i][j][0] = min_2;
                }
            }
        }
        for (int i=0; i<l_house; i++) {
            for (int j=0; i<l_paint; j++) {
                System.out.print(dp[i][j][0] + " ");
            }
            System.out.println();
        }
        return min_1;
    }
}

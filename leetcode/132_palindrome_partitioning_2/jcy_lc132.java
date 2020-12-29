public class jcy_lc132 {
    public int minCut(String s) {
        int n = s.length();
        int[] minCuts = new int[n];
        boolean[][] dp = new boolean[n][n];
        for (int j = 0; j < n; j++) {
            minCuts[j] = j;
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (i == 0) minCuts[j] = 0;
                    else minCuts[j] = Math.min(minCuts[j], minCuts[i - 1] + 1);
                }
            }
        }
        return minCuts[n - 1];
    }
}
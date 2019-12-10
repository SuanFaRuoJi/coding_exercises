public class lc_801 {
    public int minSwap(int[] A, int[] B) {
        int length = A.length;
        int[][] dp = new int[length][2];
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i=1; i<length; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = Integer.MAX_VALUE;
            if (A[i] > A[i-1] && B[i] > B[i-1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i-1][0]);
                dp[i][1] = Math.min(dp[i][1], dp[i-1][1]+1);
            }
            if (A[i] > B[i-1] && B[i] > A[i-1]) {
                dp[i][0] = Math.min(dp[i][0], dp[i-1][1]);
                dp[i][1] = Math.min(dp[i][1], dp[i-1][0]+1);
            }
        }
        return Math.min(dp[length-1][0], dp[length-1][1]);
    }
}

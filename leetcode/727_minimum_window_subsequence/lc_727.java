public class lc_727 {
    public String minWindow(String S, String T) {
        int width = S.length(), height = T.length();
        int[][] dp = new int[height][width];
        dp[0][0] = S.charAt(0)==T.charAt(0) ? 0 : -1;
        for (int i=1; i<width; i++) {
            if (S.charAt(i) == T.charAt(0)) {
                dp[0][i] = i;
            } else {
                dp[0][i] = dp[0][i-1];
            }
        }
        for (int i=1; i<height; i++) {
            dp[i][0] = -1;
        }
        for (int i=1; i<height; i++) {
            char key = T.charAt(i);
            for (int j=1; j<width; j++) {
                char match = S.charAt(j);
                if (key == match) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        int min = Integer.MAX_VALUE, min_arg = -1;
        for (int i=0; i<width; i++) {
            if (dp[height-1][i] != -1) {
                int cur = i - dp[height-1][i] + 1;
                if (cur < min) {
                    min = cur;
                    min_arg = i;
                }
            }
        }
        return S.substring(dp[height-1][min_arg], min_arg);
    }
}

public class jcy_lc727_dp {
    public String minWindow(String S, String T) {
        int sLen = S.length(), tLen = T.length();
        int[][] dp = new int[sLen + 1][tLen + 1];
        for (int i = 0; i < sLen + 1; i++)
            dp[i][0] = i + 1;
        for (int i = 1; i < sLen + 1; i++) {
            for (int j = 1; j < tLen + 1; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = dp[i - 1][j];
            }
        }
        int start = 0, len = sLen + 1;
        for (int i = 1; i < sLen + 1; i++) {
            if (dp[i][tLen] != 0) {
                if (i - dp[i][tLen] + 1 < len) {
                    start = dp[i][tLen] - 1;
                    len = i - dp[i][tLen] + 1;
                }
            }
        }
        return len == sLen + 1 ? "" : S.substring(start, start + len);
    }
}
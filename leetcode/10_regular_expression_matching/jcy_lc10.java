public class jcy_lc10 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j < n; j++)
            if (p.charAt(j) == '*' && dp[0][j - 1])
                dp[0][j + 1] = true;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (p.charAt(j - 1) == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                if (p.charAt(j - 1) == s.charAt(i - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.')
                        dp[i][j] = dp[i][j - 2];
                    else dp[i][j] = (dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2]);
                }
            }
        }
        return dp[m][n];
    }
}
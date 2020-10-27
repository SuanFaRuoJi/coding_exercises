public class wsz_72 {
    public int minDistance(String word1, String word2) {
        char[] word2_char = word2.toCharArray();
        int length1 = word1.length(), length2 = word2.length();
        if (length1 == 0 || length2 == 0) {
            return length1 + length2;
        }
        int[][] dp = new int[length1+1][length2+1];
        for (int i=0; i<=length1; i++) {
            dp[i][0] = i;
        }
        for (int j=0; j<=length2; j++) {
            dp[0][j] = j;
        }
        for (int i=0; i<length1; i++) {
            char cur1 = word1.charAt(i);
            int i_dp = i+1;
            for (int j=0; j<length2; j++) {
                char cur2 = word2_char[j];
                int j_dp = j+1;
                if (cur2 == cur1) {
                    dp[i_dp][j_dp] = dp[i_dp-1][j_dp-1];
                } else {
                    int a = dp[i_dp-1][j_dp], b = dp[i_dp][j_dp-1], c = dp[i_dp-1][j_dp-1];
                    dp[i_dp][j_dp] = Math.min(Math.min(a, b), c) + 1;
                }
            }
        }
        return dp[length1][length2];
    }
}

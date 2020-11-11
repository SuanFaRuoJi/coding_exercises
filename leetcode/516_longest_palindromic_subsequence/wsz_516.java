class Solution {
    public int longestPalindromeSubseq(String s) {
		int length = s.length();
		if (length <= 1) {
			return length;
		}
		int[][] dp = new int[length][length];

		char[] chars = s.toCharArray();
		int max = 1;
		for (int i=0; i<length; i++) {
			dp[i][i] = 1;
		}
		for (int i=1; i<length; i++) {
			int j = 0;
			while (j+i < length) {
				int left = j, right = j+i;
				dp[left][right] = Math.max(dp[left][right-1], dp[left+1][right-1]);
				if (chars[left] == chars[right]) {
					dp[left][right] = Math.max(dp[left][right], 2+dp[left+1][right-1]);
				}
				max = Math.max(max, dp[left][right]);
				j++;
			}
		}
		return max;
    }
}

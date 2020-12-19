public class jcy_lc1143_optimized {
    public int longestCommonSubsequence(String text1, String text2) {
        int[] prev = new int[text2.length() + 1];
        int[] curr = new int[text2.length() + 1];
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    curr[j] = prev[j - 1] + 1;
                } else {
                    curr[j] = Math.max(curr[j - 1], prev[j]);
                }
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[text2.length()];
    }
}
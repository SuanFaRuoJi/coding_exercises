public class jcy_lc1143_optimized {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1.length() > text2.length()) {
            String temp = text1;
            text1 = text2;
            text2 = temp;
        }
        int[] prev = new int[text1.length() + 1];
        int[] curr = new int[text1.length() + 1];
        for (int i = 1; i < text2.length() + 1; i++) {
            for (int j = 1; j < text1.length() + 1; j++) {
                if (text1.charAt(j - 1) == text2.charAt(i - 1))
                    curr[j] = prev[j - 1] + 1;
                else
                    curr[j] = Math.max(curr[j - 1], prev[j]);
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[text1.length()];
    }
}
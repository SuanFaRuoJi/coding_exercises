public class jcy_lc3 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int i = 0, j = 0;
        int[] map = new int[256];
        while (j < s.length()) {
            map[s.charAt(j)] += 1;
            while (map[s.charAt(j)] > 1) {
                map[s.charAt(i)] -= 1;
                i += 1;
            }
            res = Math.max(res, j - i + 1);
            j += 1;
        }
        return res;
    }
}
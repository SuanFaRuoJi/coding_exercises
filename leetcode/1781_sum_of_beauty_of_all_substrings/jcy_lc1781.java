public class jcy_lc1781 {
    public int beautySum(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] map = new int[26];
            for (int j = i; j < s.length(); j++) {
                map[s.charAt(j) - 'a'] += 1;
                res += helper(map);
            }
        }
        return res;
    }

    private int helper(int[] map) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) {
                min = Math.min(min, map[i]);
                max = Math.max(max, map[i]);
            }
        }
        return max - min;
    }
}
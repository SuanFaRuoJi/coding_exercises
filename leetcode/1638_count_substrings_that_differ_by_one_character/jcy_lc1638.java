public class jcy_lc1638 {
    public int countSubstrings(String s, String t) {
        int res = 0 ;
        for (int i = 0; i < s.length(); i++)
            res += helper(s, t, i, 0);
        for (int j = 1; j < t.length(); j++)
            res += helper(s, t, 0, j);
        return res;
    }

    private int helper(String s, String t, int i, int j) {
        int res = 0, pre = 0, cur = 0, n = s.length(), m = t.length();
        while (i < n && j < m) {
            cur += 1;
            if (s.charAt(i) != t.charAt(j)) {
                pre = cur;
                cur = 0;
            }
            res += pre;
            i += 1; j += 1;
        }
        return res;
    }
}
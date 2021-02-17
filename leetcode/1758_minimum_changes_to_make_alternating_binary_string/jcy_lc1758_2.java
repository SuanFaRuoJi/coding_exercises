public class jcy_lc1758_2 {
    public int minOperations(String s) {
        int res = 0, n = s.length();
        for (int i = 0; i < n; i++)
            if (s.charAt(i) - '0' != i % 2) res += 1;
        return Math.min(res, n - res);
    }
}
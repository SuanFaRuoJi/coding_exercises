public class jcy_lc647 {
    public int countSubstrings(String s) {
        int n = s.length(), res = 0;
        for (int i = 0; i < 2 * n - 1; i++) {
            int left = i / 2, right = left + i % 2;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                res += 1;
                left -= 1; right += 1;
            }
        }
        return res;
    }
}

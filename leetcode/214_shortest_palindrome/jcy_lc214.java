public class jcy_lc214 {
    public String shortestPalindrome(String s) {
        int n = s.length(), minLen = n * 2, idx = -1;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            int left = i / 2, right = left + i % 2;
            while (left >= 0) {
                if (s.charAt(left) != s.charAt(right)) {
                    flag = false;
                    break;
                } else left -= 1; right += 1;
            }
            if (flag) {
                int curLen = 0;
                if (i % 2 == 0) curLen = 2 * (n - i / 2) - 1;
                else curLen = 2 * (n - i / 2 - 1);
                if (curLen < minLen) {
                    minLen = curLen;
                    idx = i;
                }
            }
        }
        if (idx == -1) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i > idx / 2; i--)
            sb.append(s.charAt(i));
        if (idx % 2 == 0) sb.append(s.charAt(idx / 2));
        for (int i = idx / 2 + 1; i < n; i++)
            sb.append(s.charAt(i));
        return sb.toString();
    }
}
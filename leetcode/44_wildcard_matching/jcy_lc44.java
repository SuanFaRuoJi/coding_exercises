public class jcy_lc44 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length(), i = 0, j = 0, star = -1, temp = -1;
        while (i < m) {
            if (j < n && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
                i += 1; j += 1;
            } else if (j < n && p.charAt(j) == '*') {
                star = j;
                temp = i;
                j += 1;
            } else if (star == -1) return false;
            else {
                j = star + 1;
                i = temp + 1;
                temp = i;
            }
        }
        for (int k = j; k < n; k++) if (p.charAt(k) != '*') return false;
        return true;
    }
}
public class chengyou_lc1163 {
    public String lastSubstring(String s) {
        int n = s.length(), i = 0, j = 1, offset = 0;
        while (i + offset < n && j + offset < n) {
            char c = s.charAt(i + offset), d = s.charAt(j + offset);
            if (c == d) offset += 1;
            else {
                if (c < d) i += offset + 1;
                else j += offset + 1;
                if (i == j) j += 1;
                offset = 0;
            }
        }
        return s.substring(i);
    }
}

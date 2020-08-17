public class java_1163 {
    public String lastSubstring(String s) {
        int start = 0, i = 1;
        while (i < s.length()) {
            int j = start, anchor = i;
            while (i < s.length() && j != anchor) {
                char prev = s.charAt(j), cur = s.charAt(i);
                if (prev < cur) {
                    start = cur <= s.charAt(anchor) ? anchor : i;
                    break;
                } else if (prev > cur) {
                    break;
                }
                j ++;
                i ++;
            }
            if (j != anchor) {
                i ++;
            }
        }
        return s.substring(start);
    }
}

public class java_1163 {
    public String lastSubstring(String s) {
        int start = 0, i = 0;
        while (i < s.length()) {
            int j = start, anchor = i;
            while (i < s.length() && j != anchor) {
                System.out.println(i + " " + j);
                char prev = s.charAt(j), cur = s.charAt(i);
                if (prev < cur) {
                    start = i;
                    break;
                } else if (prev > cur) {
                    break;
                }
                j ++;
                i ++;
            }
            i ++;
        }
        return s.substring(start);
    }
}

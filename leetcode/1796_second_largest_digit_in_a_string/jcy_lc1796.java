public class jcy_lc1796 {
    public int secondHighest(String s) {
        int max = -1, sec = -1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int cur = s.charAt(i) - '0';
                if (cur > max) {
                    sec = max;
                    max = cur;
                } else if (cur < max && cur > sec) sec = cur;
            }
        }
        return sec;
    }
}
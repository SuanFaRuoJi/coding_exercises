public class jcy_lc1541 {
    public int minInsertions(String s) {
        int res = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (right % 2 != 0) {
                    right -= 1;
                    res += 1;
                }
                right += 2;
            } else {
                right -= 1;
                if (right < 0) {
                    right += 2;
                    res += 1;
                }
            }
        }
        return res + right;
    }
}
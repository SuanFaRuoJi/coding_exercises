public class jcy_lc678 {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                low += 1;
                high += 1;
            } else if (s.charAt(i) == ')') {
                if (low > 0) low -= 1;
                high -= 1;
            } else {
                if (low > 0) low -= 1;
                high += 1;
            }
            if (high < 0) return false;
        }
        return low == 0;
    }
}
public class jcy_lc32_3 {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left += 1;
            else right += 1;
            if (left == right) res = Math.max(res, 2 * right);
            else if (right > left) left = right = 0;
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') left += 1;
            else right += 1;
            if (left == right) res = Math.max(res, 2 * left);
            else if (left > right) left = right = 0;
        }
        return res;
    }
}
public class chengyou_lc125 {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        s = s.toLowerCase();
        int n = s.length(), i = 0, j = n - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i)))
                i += 1;
            else if (!Character.isLetterOrDigit(s.charAt(j)))
                j -= 1;
            else {
                if (s.charAt(i) != s.charAt(j)) return false;
                i += 1; j -= 1;
            }
        }
        return true;
    }
}
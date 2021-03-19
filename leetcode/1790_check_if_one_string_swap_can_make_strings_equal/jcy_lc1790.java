public class jcy_lc1790 {
    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        char s1First = ' ', s1Sec = ' ', s2First = ' ', s2Sec = ' ';
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1First == ' ') {
                    s1First = s1.charAt(i);
                    s2First = s2.charAt(i);
                } else if (s1Sec == ' ') {
                    s1Sec = s1.charAt(i);
                    s2Sec = s2.charAt(i);
                } else return false;
            }
        }
        if (s1First == ' ') {
            if (s1Sec == ' ') return true;
            else return false;
        }
        return s1First == s2Sec && s1Sec == s2First;
    }
}
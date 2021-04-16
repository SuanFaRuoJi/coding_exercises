public class jcy_lc58 {
    public int lengthOfLastWord(String s) {
        int idx = s.length() - 1, res = 0;
        while (idx >= 0) {
            if (s.charAt(idx--) != ' ') res += 1;
            else if (res > 0) return res;
        }
        return res;
    }
}
public class jcy_lc1750 {
    public int minimumLength(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            char cur = s.charAt(i);
            while (i <= j && s.charAt(i) == cur) i += 1;
            while (i <= j && s.charAt(j) == cur) j -= 1;
        }
        return j - i + 1;
    }
}
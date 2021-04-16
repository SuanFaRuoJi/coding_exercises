public class jcy_lc1816 {
    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') if (--k == 0) return sb.toString();
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
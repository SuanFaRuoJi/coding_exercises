public class jcy_lc1370 {
    public String sortString(String s) {
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) freq[c - 'a'] += 1;
        while (sb.length() < s.length()) {
            for (int i = 0; i < 26; i++) {
                if (freq[i] != 0) {
                    sb.append((char)(i + 'a'));
                    freq[i] -= 1;
                }
            }
            for (int i = 25; i >= 0; i--) {
                if (freq[i] != 0) {
                    sb.append((char)(i + 'a'));
                    freq[i] -= 1;
                }
            }
        }
        return sb.toString();
    }
}
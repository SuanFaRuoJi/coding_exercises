public class jcy_lc1400 {
    public boolean canConstruct(String s, int k) {
        if (s.length() < k) return false;
        int[] map = new int[26];
        for (char c : s.toCharArray()) map[c - 'a'] += 1;
        int odd = 0;
        for (int i = 0; i < 26; i++) if (map[i] % 2 == 1) odd += 1;
        if (odd > k) return false;
        else return true;
    }
}
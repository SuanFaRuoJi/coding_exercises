public class jcy_lc205 {
    public boolean isIsomorphic(String s, String t) {
        int[] map = new int[256];
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] != map[t.charAt(i) + 128]) return false;
            map[s.charAt(i)] = map[t.charAt(i) + 128] = i + 1;
        }
        return true;
    }
}
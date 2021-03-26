public class jcy_lc1684 {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] record = new int[26];
        int res = words.length;
        for (char c : allowed.toCharArray())
            if (record[c - 'a'] == 0) record[c - 'a'] = 1;
        for (String s : words) {
            for (char c : s.toCharArray()) {
                if (record[c - 'a'] == 0) {
                    res -= 1;
                    break;
                }
            }
        }
        return res;
    }
}
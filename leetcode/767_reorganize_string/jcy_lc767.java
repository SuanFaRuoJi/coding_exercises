public class jcy_lc767 {
    public String reorganizeString(String S) {
        int[] map = new int[26];
        for (int i = 0; i < S.length(); i++)
            map[S.charAt(i) - 'a'] += 1;
        int maxFreq = 0, maxFreqChar = 0;
        for (int i = 0; i < 26; i++) {
            if (map[i] > maxFreq) {
                maxFreq = map[i];
                maxFreqChar = i;
            }
        }
        if (maxFreq > (S.length() + 1) / 2) return "";
        char[] res = new char[S.length()];
        int idx = 0;
        while (map[maxFreqChar] > 0) {
            res[idx] = (char)(maxFreqChar + 'a');
            idx += 2;
            map[maxFreqChar] -= 1;
        }
        for (int i = 0; i < 26; i++) {
            while (map[i] > 0) {
                if (idx >= res.length) idx = 1;
                res[idx] = (char)(i + 'a');
                idx += 2;
                map[i] -= 1;
            }
        }
        return String.valueOf(res);
    }
}
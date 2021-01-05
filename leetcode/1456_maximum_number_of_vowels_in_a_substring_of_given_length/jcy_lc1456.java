public class jcy_lc1456 {
    public int maxVowels(String s, int k) {
        int res = 0, cur = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i < k) {
                if (isVowel(s.charAt(i))) cur += 1;
            } else {
                if (isVowel(s.charAt(i))) cur += 1;
                if (isVowel(s.charAt(i - k))) cur -= 1;
            }
            res = Math.max(res, cur);
        }
        return res;
    }

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        else return false;
    }
}
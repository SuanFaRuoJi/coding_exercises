public class wsz_java_87 {
    public boolean isScramble(String s1, String s2) {
        return recurse(s1, s2, 0, s1.length()-1, 0, s2.length()-1);
    }

    private boolean recurse(String s1, String s2, int l1, int r1, int l2, int r2) {
        if (l1 == r1) {
            return s1.charAt(l1) == s2.charAt(l2);
        }

        int[] hash1 = new int[26], hash2 = new int[26], hash2_reverse = new int[26];
        int possible = 0, possible_reverse = 0;
        for (int i=0; i<r1-l1; i++) {
            int cur1 = s1.charAt(i+l1) - 'a';
            if (hash1[cur1] == hash2[cur1]) {
                possible --;
            }
            if (hash1[cur1] == hash2_reverse[cur1]) {
                possible_reverse --;
            }
            hash1[cur1] ++;
            int cur2 = s2.charAt(i+l2) - 'a';
            hash2[cur2] ++;
            if (hash2[cur2] == hash1[cur2]) {
                possible ++;
            }
            if (possible == 0) {
                boolean result1 = recurse(s1, s2, l1+i+1, r1, l2+i+1, r2),
                        result2 = recurse(s1, s2, l1, l1+i, l2, l2+i);
                if (result1 && result2) {
                    return true;
                }
            }

            int cur2_reverse = s2.charAt(r2 - i) - 'a';
            hash2_reverse[cur2_reverse] ++;
            if (hash2_reverse[cur2_reverse] == hash1[cur2_reverse]) {
                possible_reverse ++;
            }
            if (possible_reverse == 0) {
                boolean result1 = recurse(s1, s2, l1+i+1, r1, l2, r2 - i - 1),
                        result2 = recurse(s1, s2, l1, l1+i, r2-i, r2);
                if (result1 && result2) {
                    return true;
                }
            }
        }
        return false;
    }
}

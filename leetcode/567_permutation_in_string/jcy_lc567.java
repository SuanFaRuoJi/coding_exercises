public class jcy_lc567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int[] map1 = new int[26], map2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            map1[s1.charAt(i) - 'a'] += 1;
            map2[s2.charAt(i) - 'a'] += 1;
        }
        int count = 0;
        for (int i = 0; i < 26; i++)
            if (map1[i] == map2[i]) count += 1;
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            int r = s2.charAt(i + s1.length()) - 'a', l = s2.charAt(i) - 'a';
            if (count == 26) return true;
            map2[r] += 1;
            if (map2[r] == map1[r]) count += 1;
            else if (map2[r] == map1[r] + 1) count -= 1;
            map2[l] -= 1;
            if (map2[l] == map1[l]) count += 1;
            else if (map2[l] == map1[l] - 1) count -= 1;
        }
        return count == 26;
    }
}
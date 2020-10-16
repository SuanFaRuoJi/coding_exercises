import java.util.ArrayList;
import java.util.List;

public class jcy_lc438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;
        int[] map1 = new int[26], map2 = new int[26];
        for (int i = 0; i < p.length(); i++) {
            map1[p.charAt(i) - 'a'] += 1;
            map2[s.charAt(i) - 'a'] += 1;
        }
        int count = 0;
        for (int i = 0; i < 26; i++)
            if (map1[i] == map2[i]) count += 1;
        if (count == 26) res.add(0);
        for (int i = 0; i < s.length() - p.length(); i++) {
            int l = s.charAt(i) - 'a', r = s.charAt(i + p.length()) - 'a';
            map2[r] += 1;
            if (map2[r] == map1[r]) count += 1;
            else if (map2[r] == map1[r] + 1) count -= 1;
            map2[l] -= 1;
            if (map2[l] == map1[l]) count += 1;
            else if (map2[l] == map1[l] - 1) count -= 1;
            if (count == 26) res.add(i + 1);
        }
        return res;
    }
}
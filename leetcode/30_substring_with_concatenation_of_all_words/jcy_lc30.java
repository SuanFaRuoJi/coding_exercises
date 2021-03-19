import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class jcy_lc30 {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) map.put(w, map.getOrDefault(w, 0) + 1);
        List<Integer> res = new ArrayList<>();
        int n = s.length(), num = words.length, len = words[0].length();
        for (int i = 0; i <= n - num * len; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < num) {
                String cur = s.substring(i + j * len, i + (j + 1) * len);
                if (map.containsKey(cur)) {
                    seen.put(cur, seen.getOrDefault(cur, 0) + 1);
                    if (seen.get(cur) > map.getOrDefault(cur, 0)) break;
                } else break;
                j += 1;
            }
            if (j == num) res.add(i);
        }
        return res;
    }
}
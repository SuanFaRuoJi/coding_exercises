import java.util.HashMap;
import java.util.Map;

public class jcy_lc159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, n = s.length(), res = 0, count = 0;
        while (j < n) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) count += 1;
            j += 1;
            while (count > 2) {
                char curr = s.charAt(i);
                map.put(curr, map.get(curr) - 1);
                if (map.get(curr) == 0) count -= 1;
                i += 1;
            }
            res = Math.max(res, j - i);
        }
        return res;
    }
}
import java.util.HashMap;
import java.util.Map;

public class jcy_lc340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0, numOfKeys = 0, res = 0;
        while (j < s.length()) {
            if (map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j)) + 1);
            } else {
                map.put(s.charAt(j), 1);
                numOfKeys += 1;
            }
            while (numOfKeys > k) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                if (map.get(s.charAt(i)) == 0) {
                    map.remove(s.charAt(i));
                    numOfKeys -= 1;
                }
                i += 1;
            }
            res = Math.max(res, j - i + 1);
            j += 1;
        }
        return res;
    }
}
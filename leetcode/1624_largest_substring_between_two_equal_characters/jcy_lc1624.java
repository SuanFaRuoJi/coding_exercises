import java.util.HashMap;
import java.util.Map;

public class jcy_lc1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int res = -1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)))
                res = Math.max(i - map.get(s.charAt(i)) - 1, res);
            else map.put(s.charAt(i), i);
        }
        return res;
    }
}
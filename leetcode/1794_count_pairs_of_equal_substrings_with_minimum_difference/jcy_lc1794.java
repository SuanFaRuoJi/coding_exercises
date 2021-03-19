import java.util.HashMap;
import java.util.Map;

public class jcy_lc1794 {
    public int countQuadruples(String firstString, String secondString) {
        Map<Character, Integer> map = new HashMap<>();
        int dist = Integer.MAX_VALUE, res = 0;
        for (int i = 0; i < firstString.length(); i++)
            map.putIfAbsent(firstString.charAt(i), i);
        for (int i = 0; i < secondString.length(); i++) {
            char cur = secondString.charAt(i);
            if (map.containsKey(cur)) {
                if (map.get(cur) - i < dist) {
                    dist = map.get(cur) - i;
                    res = 1;
                } else if (map.get(cur) - i == dist) res += 1;
            }
        }
        return res;
    }
}
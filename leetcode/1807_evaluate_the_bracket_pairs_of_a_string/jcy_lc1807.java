import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class jcy_lc1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder sb = new StringBuilder();
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) map.put(pair.get(0), pair.get(1));
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '(') {
                StringBuilder cur = new StringBuilder();
                i += 1;
                while (s.charAt(i) != ')') cur.append(s.charAt(i++));
                if (map.containsKey(cur.toString()))
                    sb.append(map.get(cur.toString()));
                else sb.append('?');
            } else sb.append(s.charAt(i));
            i += 1;
        }
        return sb.toString();
    }
}
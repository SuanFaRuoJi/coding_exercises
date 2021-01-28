import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class jcy_lc811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            int idx = s.indexOf(' ');
            int count = Integer.valueOf(s.substring(0, idx));
            String website = s.substring(idx + 1);
            for (int i = 0; i < website.length(); i++) {
                if (website.charAt(i) == '.') {
                    String cur = website.substring(i + 1);
                    map.put(cur, map.getOrDefault(cur, 0) + count);
                }
            }
            map.put(website, map.getOrDefault(website, 0) + count);
        }
        List<String> res = new ArrayList<>();
        for (String s : map.keySet()) res.add(map.get(s) + " " + s);
        return res;
    }
}
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class wsz_java_291 {
    private Map<Character, String> pattern_map = new HashMap<>();
    private Set<String> pattern_cross = new HashSet<>();

    public boolean wordPatternMatch(String pattern, String str) {
        int[] cross = new int[26];
        int total = 0;
        for (int i=0; i<pattern.length(); i++) {
            int cur = pattern.charAt(i) - 'a';
            if (cross[cur] == 0) {
                total++;
                cross[cur] = 1;
            }
        }
        return match(pattern, str, 0, 0, 0, total);
    }

    private boolean match(String pattern, String str, int a, int b, int count, int total) {
        if (a == pattern.length()) {
            return count == total && b == str.length();
        }
        char cur = pattern.charAt(a);
        if (pattern_map.containsKey(cur)) { // direct match
            String cur_match = pattern_map.get(cur);
            if (!cur_match.equals(str.substring(b, Math.min(b+cur_match.length(), str.length())))) {
                return false;
            } else {
                return match(pattern, str, a+1, Math.min(b+cur_match.length(), str.length()), count, total);
            }
        } else { // guess
            StringBuilder builder = new StringBuilder();
            for (int i = b; i < str.length(); i++) {
                builder.append(str.charAt(i));
                if (pattern_cross.contains(builder.toString())) {
                    continue;
                }
                pattern_map.put(cur, builder.toString());
                pattern_cross.add(builder.toString());
                if (match(pattern, str, a+1, i+1, count+1, total)) {
                    return true;
                }
                pattern_map.remove(cur);
                pattern_cross.remove(builder.toString());
            }
            return false;
        }
    }
}

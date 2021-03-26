import java.util.HashSet;
import java.util.Set;

public class jcy_lc1763 {
    public String longestNiceSubstring(String s) {
        if (s.length() < 2) return "";
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) set.add(c);
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (set.contains(Character.toUpperCase(cur)) && set.contains(Character.toLowerCase(cur))) continue;
            String sub1 = longestNiceSubstring(s.substring(0, i));
            String sub2 = longestNiceSubstring(s.substring(i + 1));
            return sub1.length() >= sub2.length() ? sub1 : sub2;
        }
        return s;
    }
}
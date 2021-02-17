import java.util.ArrayList;
import java.util.List;

public class jcy_lc267 {
    public List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int[] map = new int[256];
        for (int i = 0; i < s.length(); i++) map[s.charAt(i)] += 1;
        int odd = 0;
        for (int i = 0; i < map.length; i++)
            if (map[i] % 2 != 0) sb.append((char) i);
        if (sb.length() > 1) return res;
        helper(sb, res, map, s.length());
        return res;
    }

    private void helper(StringBuilder sb, List<String> res, int[] map, int len) {
        if (sb.length() == len) {
            res.add(sb.toString());
            return;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 1) {
                map[i] -= 2;
                sb.insert(0, (char) i);
                sb.append((char) i);
                helper(sb, res, map, len);
                sb.deleteCharAt(0);
                sb.deleteCharAt(sb.length() - 1);
                map[i] += 2;
            }
        }
    }
}
import java.util.ArrayList;
import java.util.List;

public class jcy_lc93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), s, 0, 0);
        return res;
    }

    private void helper(List<String> res, StringBuilder sb, String s, int start, int count) {
        if (start == s.length() && count == 4) res.add(sb.toString());
        else if (count == 4) return;
        for (int i = start; i < s.length(); i++) {
            String cur = s.substring(start, i + 1);
            int val = Integer.parseInt(cur);
            if (cur.length() > 1 && cur.charAt(0) == '0') return;
            if (val > 255) return;
            if (val <= 255 && val >= 0) {
                StringBuilder temp = new StringBuilder(sb);
                sb.append(s.substring(start, i + 1));
                if (count < 3) sb.append(".");
                helper(res, sb, s, i + 1, count + 1);
                sb = temp;
            }
        }
    }
}
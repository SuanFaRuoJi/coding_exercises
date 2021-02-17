import java.util.ArrayList;
import java.util.List;

public class jcy_lc320 {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        helper(res, new StringBuilder(), word, 0, 0);
        return res;
    }

    private void helper(List<String> res, StringBuilder sb, String word, int i, int j) {
        int len = sb.length();
        if (i == word.length()) {
            if (j != 0) sb.append(j);
            res.add(sb.toString());
        } else {
            helper(res, sb, word, i + 1, j + 1);
            if (j != 0) sb.append(j);
            sb.append(word.charAt(i));
            helper(res, sb, word, i + 1, 0);
        }
        sb.setLength(len);
    }
}
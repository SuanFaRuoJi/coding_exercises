import java.util.ArrayList;
import java.util.List;

public class lc_809 {
    public int expressiveWords(String S, String[] words) {
        List<int[]> s_format = format(S);
        List<int[]>[] words_format = new List[words.length];
        for (int i=0; i<words.length; i++) {
            words_format[i] = format(words[i]);
        }
        int count = 0;
        for (int i=0; i<words_format.length; i++) {
            List<int[]> cur_format = words_format[i];
            if (cur_format.size() != s_format.size()) {
                continue;
            }
            count ++;
            for (int j=0; j<cur_format.size(); j++) {
                int[] cur_char = cur_format.get(j), s_char = s_format.get(j);
                if (cur_char[0] != s_char[0]) {
                    count --;
                    break;
                }
                if (cur_char[1] != s_char[1] && s_char[1]%3 != 0) {
                    count --;
                    break;
                }
            }
        }
        return count;
    }

    private List<int[]> format(String s) {
        int prev = -1, count = 0;
        List<int[]> result = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            int cur = s.charAt(i);
            if (cur != prev) {
                int[] to_add = {prev, count};
                result.add(to_add);
                count = 0;
            }
            count ++;
            prev = cur;
        }
        int[] to_add = {prev, count};
        result.add(to_add);
        return result;
    }
}

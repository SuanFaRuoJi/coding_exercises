import java.util.ArrayList;
import java.util.List;

public class jcy_lc763 {
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        int[] lastSeen = new int[26];
        for (int i = 0; i < S.length(); i++)
            lastSeen[S.charAt(i) - 'a'] = i;
        int start = 0, end = 0;
        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, lastSeen[S.charAt(i) - 'a']);
            if (i == end) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }
        return res;
    }
}
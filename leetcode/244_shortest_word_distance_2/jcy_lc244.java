import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class jcy_lc244 {private Map<String, List<Integer>> map = new HashMap<>();

    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; i++) {
            map.putIfAbsent(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1), list2 = map.get(word2);
        int i = 0, j = 0, res = Integer.MAX_VALUE;
        while (i < list1.size() && j < list2.size()) {
            int idx1 = list1.get(i), idx2 = list2.get(j);
            res = Math.min(res, Math.abs(idx1 - idx2));
            if (idx1 < idx2) i += 1;
            else j += 1;
        }
        return res;
    }
}
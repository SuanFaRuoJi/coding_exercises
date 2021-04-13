import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class jcy_lc140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, wordDict, new HashMap<String, List<String>>());
    }

    private List<String> helper(String s, List<String> wordDict, Map<String, List<String>> map) {
        if (map.containsKey(s)) return map.get(s);
        List<String> res = new ArrayList<>();
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                String next = s.substring(word.length());
                if (next.length() == 0) res.add(word);
                else {
                    List<String> curList = helper(next, wordDict, map);
                    for (String cur : curList) res.add(word + " " + cur);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
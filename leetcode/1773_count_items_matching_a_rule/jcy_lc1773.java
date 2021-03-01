import java.util.List;

public class jcy_lc1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        if (ruleKey.equals("type")) return helper(items, ruleValue, 0);
        else if (ruleKey.equals("color")) return helper(items, ruleValue, 1);
        else return helper(items, ruleValue, 2);
    }

    private int helper(List<List<String>> items, String ruleValue, int idx) {
        int cnt = 0;
        for (List<String> list : items)
            if (list.get(idx).equals(ruleValue))
                cnt += 1;
        return cnt;
    }
}
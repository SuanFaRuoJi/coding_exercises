import java.util.ArrayList;
import java.util.List;

public class jcy_lc131 {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        List<List<String>> res = new ArrayList<>();
        backtracking(res, s, 0, new ArrayList<>(), dp);
        return res;
    }

    private void backtracking(List<List<String>> res, String s, int start, List<String> cur, boolean[][] dp) {
        if (start >= s.length()) res.add(new ArrayList<>(cur));
        for (int end = start; end < s.length(); end++) {
            if (s.charAt(start) == s.charAt(end) && (end - start <= 2 || dp[start + 1][end - 1])) {
                dp[start][end] = true;
                cur.add(s.substring(start, end + 1));
                backtracking(res, s, end + 1, cur, dp);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
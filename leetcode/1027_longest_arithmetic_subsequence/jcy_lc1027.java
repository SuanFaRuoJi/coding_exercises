import java.util.HashMap;
import java.util.Map;

public class jcy_lc1027 {
    public int longestArithSeqLength(int[] A) {
        int res = 2, n = A.length;
        Map<Integer, Integer>[] dp = new HashMap[n];
        for (int j = 0; j < n; j++) {
            dp[j] = new HashMap<>();
            for (int i = 0; i < j; i++) {
                int diff = A[j] - A[i];
                dp[j].put(diff, dp[i].getOrDefault(diff, 1) + 1);
                res = Math.max(res, dp[j].get(diff));
            }
        }
        return res;
    }
}
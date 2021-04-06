import java.util.HashMap;
import java.util.Map;

public class jcy_lc1814 {
    public int countNicePairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0, mod = 1000000007;
        for (int n : nums) {
            int cur = n - helper(n), freq = map.getOrDefault(cur, 0);
            map.put(cur, freq + 1);
            res = (res + freq) % mod;
        }
        return res;
    }

    private int helper(int n) {
        int res = 0;
        while (n != 0) {
            res *= 10;
            res += n % 10;
            n /= 10;
        }
        return res;
    }
}
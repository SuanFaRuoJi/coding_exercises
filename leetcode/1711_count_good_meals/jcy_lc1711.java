import java.util.HashMap;
import java.util.Map;

public class jcy_lc1711 {
    public int countPairs(int[] deliciousness) {
        int mod = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        long res = 0;
        for (int n : deliciousness) {
            int power = 1;
            for (int i = 0; i < 22; i++) {
                if (map.containsKey(power - n)) {
                    res += map.get(power - n);
                    res %= mod;
                }
                power *= 2;
            }
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return (int)res;
    }
}
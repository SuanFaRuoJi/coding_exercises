import java.util.*;

public class chengyou_lc992 {
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K - 1);
    }

    private int atMostK(int[] A, int K) {
        int res = 0, i = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < A.length; j++) {
            if (!map.containsKey(A[j])) count += 1;
            map.put(A[j], map.getOrDefault(A[j], 0) + 1);
            while (count > K) {
                map.put(A[i], map.get(A[i]) - 1);
                if (map.get(A[i]) == 0) {
                    count -= 1;
                    map.remove(A[i]);
                }
                i += 1;
            }
            res += j - i + 1;
        }
        return res;
    }
}

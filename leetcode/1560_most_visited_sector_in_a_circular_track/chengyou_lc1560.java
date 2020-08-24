import java.util.*;

public class chengyou_lc1560 {
    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> res = new ArrayList<>();
        int start = rounds[0], end = rounds[rounds.length - 1];
        if (start <= end) {
            for (int i = start; i <= end; i++)
                res.add(i);
        } else {
            for (int i = 1; i <= end; i++)
                res.add(i);
            for (int i = start; i <= n; i++)
                res.add(i);
        }
        return res;
    }
}

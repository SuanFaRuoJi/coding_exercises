import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc_939 {
    public int minAreaRect(int[][] points) {
        int length = points.length;
        Map<Integer, Set<Integer>> x_hash = new HashMap<>(), y_hash = new HashMap<>();
        for (int i=0; i<length; i++) {
            int x = points[i][0], y = points[i][1];
            if (!x_hash.containsKey(x)) {
                x_hash.put(x, new HashSet<>());
            }
            Set<Integer> cross = x_hash.get(x);
            cross.add(y);
            x_hash.put(x, cross);
            if (!y_hash.containsKey(y)) {
                y_hash.put(y, new HashSet<>());
            }
            cross = y_hash.get(y);
            cross.add(x);
            y_hash.put(y, cross);
        }
        int minimum = Integer.MAX_VALUE;
        for (int i=0; i<length-1; i++) {
            for (int j=i+1; j<length; j++) {
                if (points[i][0] != points[j][0] && points[i][1] != points[j][1]) { // possible rectangle
                    if (x_hash.get(points[i][0]).contains(points[j][1]) && y_hash.get(points[i][1]).contains(points[j][0])) {
                        minimum = Math.min(minimum, Math.abs(points[i][0]-points[j][0]) * Math.abs(points[i][1]-points[j][1]));
                    }
                }
            }
        }
        return minimum == Integer.MAX_VALUE ? 0 : minimum;
    }

    private long hash(int x, int y) {
        return x * 10000L + y;
    }
}

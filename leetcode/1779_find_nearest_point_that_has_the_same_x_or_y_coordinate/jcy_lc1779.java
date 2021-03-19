public class jcy_lc1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int dist = Integer.MAX_VALUE, res = -1;
        for (int i = 0; i < points.length; i++) {
            int[] cur = points[i];
            if (cur[0] == x || cur[1] == y) {
                if (Math.abs(cur[0] - x) + Math.abs(cur[1] - y) < dist) {
                    dist = Math.abs(cur[0] - x) + Math.abs(cur[1] - y);
                    res = i;
                }
            }
        }
        return res;
    }
}
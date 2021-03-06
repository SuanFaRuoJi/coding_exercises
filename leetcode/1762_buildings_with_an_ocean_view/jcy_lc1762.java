public class jcy_lc1762 {
    public int[] findBuildings(int[] heights) {
        int curMax = 0, n = heights.length, cnt = 0;
        int[] hasOceanView = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (heights[i] > curMax) {
                hasOceanView[i] = 1;
                cnt += 1;
            }
            curMax = Math.max(curMax, heights[i]);
        }
        int[] res = new int[cnt];
        int idx = 0;
        for (int i = 0; i < n; i++) if (hasOceanView[i] != 0) res[idx++] = i;
        return res;
    }
}
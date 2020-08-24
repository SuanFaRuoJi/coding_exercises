public class chengyou_lc1051 {
    public int heightChecker(int[] heights) {
        int[] count = new int[101];
        for (int height : heights) count[height] += 1;
        int res = 0, curHeight = 0;
        for (int i = 0; i < heights.length; i++) {
            while (count[curHeight] == 0) curHeight += 1;
            if (curHeight != heights[i]) res += 1;
            count[curHeight] -= 1;
        }
        return res;
    }
}

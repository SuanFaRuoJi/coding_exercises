public class jcy_lc11 {
    public int maxArea(int[] height) {
        int res = 0, i = 0, j = height.length - 1;
        while (i < j) {
            int water = Math.min(height[i], height[j]) * (j - i);
            res = Math.max(res, water);
            if (height[i] < height[j]) i += 1;
            else j -= 1;
        }
        return res;
    }
}
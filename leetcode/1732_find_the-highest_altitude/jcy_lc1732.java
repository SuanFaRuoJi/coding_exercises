public class jcy_lc1732 {
    public int largestAltitude(int[] gain) {
        int res = 0, cur = 0;
        for (int g : gain) {
            cur += g;
            res = Math.max(res, cur);
        }
        return res;
    }
}
public class jcy_lc1672 {
    public int maximumWealth(int[][] accounts) {
        int n = accounts.length, res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            for (int val : accounts[i])
                cur += val;
            res = Math.max(res, cur);
        }
        return res;
    }
}
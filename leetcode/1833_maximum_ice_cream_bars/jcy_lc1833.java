public class jcy_lc1833 {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int res = 0;
        for (int i = 0; i < costs.length; i++) {
            if (costs[i] <= coins) {
                res += 1;
                coins -= costs[i];
            } else break;
        }
        return res;
    }
}
public class wsz_java_123 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1){
            return 0;
        }
        /*
        if (k >= prices.length/2){ // to handle the edge case where k is so large that can sell whenever time sees fit.
            int sum = 0;
            for (int i=1; i<prices.length; i++){
                int delta = Math.max(0, prices[i] - prices[i-1]);
                sum += delta;
            }
            return sum;
        }
        */
        return bootstrap(prices, 2);
    }

    private int bootstrap(int[] prices, int times){
        int l = prices.length;
        int[] accumulate = new int[l];
        for (int index=0; index<times; index++){
            int so_far = accumulate[0], up_to = accumulate[0];
            for (int i=1; i<l; i++){
                int delta = prices[i] - prices[i-1];
                up_to = Math.max(accumulate[i], up_to + delta);
                so_far = Math.max(so_far, up_to);
                accumulate[i] = so_far;
            }
        }
        return accumulate[l-1];
    }
}
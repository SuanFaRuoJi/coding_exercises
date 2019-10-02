public class wsz_java_188 {
    public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1){
            return 0;
        }
        if (k >= prices.length/2){
            int sum = 0;
            for (int i=1; i<prices.length; i++){
                int delta = Math.max(0, prices[i] - prices[i-1]);
                sum += delta;
            }
            return sum;
        }
        int l = prices.length;
        int[] accumulate = new int[l];
        for (int index=0; index<k; index++){
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
public class wsz_java{
    public int maxProfit(int[] prices) {
        return bootstrap(prices, 2);
    }

    private int bootstrap(int[] prices, int times){
        int[] front = difference(prices, true);
        if (times == 1){
            return find_max(front);
        }
        else{
            int[] back = difference(prices, false);
            return find_max(recursion(front, back, times-1));
        }
    }

    private int[] recursion(int[] base, int[] iteration, int times){
        if (times == 1){
            int l = base.length;
            int[] toRet = new int[l];
            toRet[0] = iteration[0];
            toRet[l-1] = base[l-1];
            for (int i=1; i<l-1; i++){
                toRet[i] = base[i-1] + iteration[i];
            }
            return toRet;
        }
        int[] result = recursion(base, iteration, times-1);
        return recursion(base, result, 1);
    }

    private int find_max(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i=0; i<arr.length; i++){
            if (arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    private int[] difference(int[] arr, boolean order){
        int[] toRet = new int[arr.length];
        int up_to = 0, so_far = 0;
        if (order){ // front to back
            for (int i=1; i<arr.length; i++){
                int delta = arr[i] - arr[i-1];
                up_to = Math.max(up_to + delta, 0);
                so_far = Math.max(so_far, up_to);
                toRet[i] = so_far;
            }
        }else{ // back to front
            for (int i=arr.length-2; i>=0; i--){
                int delta = arr[i+1] - arr[i];
                up_to = Math.max(up_to + delta, 0);
                so_far = Math.max(so_far, up_to);
                toRet[i] = so_far;
            }
        }
        return toRet;
    }
}
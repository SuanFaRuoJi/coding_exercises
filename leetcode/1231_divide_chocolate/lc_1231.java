public class lc_1231 {
    public int maximizeSweetness(int[] sweetness, int K) {
        int min = Integer.MAX_VALUE, l = sweetness.length, sum=0;
        for (int i=0; i<l; i++) {
            sum += sweetness[i];
            if (sweetness[i] < min) {
                min = sweetness[i];
            }
        }
        if (K == 0) {
            return sum;
        }
        if (K+1 == l) {
            return min;
        }
        int left = min, right = sum;
        while (left+1<right) {
            int mid = (left+right)/2;
            if (min_larger_tham(sweetness, K+1, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return min;
    }

    private boolean min_larger_tham(int[] sweetness, int K, int min) {
        int sum = 0, group = 0;
        for (int i=0; i<sweetness.length; i++) {
            if (sum >= min) {
                group += 1;
                sum = 0;
                if (group >= K) {
                    return true;
                }
            }
            sum += sweetness[i];
        }
        if (sum >= min) {
            group += 1;
        }
        return group >= K;
    }
}

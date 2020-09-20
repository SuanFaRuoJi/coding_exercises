public class jcy_lc1588_2 {
    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0, n = arr.length;
        for (int i = 0; i < n; ++i)
            res += ((i + 1) * (n - i) + 1) / 2 * arr[i];
        return res;
    }
}
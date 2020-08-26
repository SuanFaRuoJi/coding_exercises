public class chengyou_lc891 {
    public int sumSubseqWidths(int[] A) {
        Arrays.sort(A);
        int n = A.length;
        long res = 0, mod = (long)1e9 + 7, multi = 1;
        for (int i = 0; i < n; i++) {
            // Note that A[i] * 2 ^ (n - i - 1) = A[n - i - 1] * 2 ^ i
            res = (res + (A[i] - A[n - i - 1]) * multi) % mod;
            multi = multi * 2 % mod;
        }
        return (int)((res + mod) % mod);
    }
}

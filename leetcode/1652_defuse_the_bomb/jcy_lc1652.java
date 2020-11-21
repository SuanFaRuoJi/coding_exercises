public class jcy_lc1652 {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        int[] P = new int[n + 1];
        if (k == 0) return res;
        for (int i = 1; i < n + 1; i++)
            P[i] = P[i - 1] + code[i - 1];
        if (k > 0) {
            for (int i = 0; i < n; i++) {
                if (i + k + 1 <= n) {
                    res[i] = P[i + k + 1] - P[i + 1];
                } else {
                    res[i] = P[n] - P[i + 1] + P[i + k + 1 - n] - P[0];
                }
            }
        } else {
            k = Math.abs(k);
            for (int i = 0; i < n; i++) {
                if (i - k >= 0) {
                    res[i] = P[i] - P[i - k];
                } else {
                    res[i] = P[i] - P[0] + P[n] - P[n - (k - i)];
                }
            }
        }
        return res;
    }
}
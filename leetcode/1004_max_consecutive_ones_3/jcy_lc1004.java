public class jcy_lc1004 {
    public int longestOnes(int[] A, int K) {
        int i = 0, j = 0, zero = 0, res = 0;
        while (j < A.length) {
            if (A[j] == 0) {
                zero += 1;
                while (zero > K) {
                    if (A[i] == 0) zero -= 1;
                    i += 1;
                }
            }
            res = Math.max(j - i + 1, res);
            j += 1;
        }
        return res;
    }
}
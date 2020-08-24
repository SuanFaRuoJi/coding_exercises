public class chengyou_lc995 {
    public int minKBitFlips(int[] A, int K) {
        int n = A.length, flipped = 0, res = 0;
        int[] isFlipped = new int[n];
        for (int i = 0; i < n; i++) {
            if (i >= K)
                flipped ^= isFlipped[i - K];
            if (flipped == A[i]) {
                if (i + K > A.length) return -1;
                isFlipped[i] = 1;
                flipped ^= 1;
                res += 1;
            }
        }
        return res;
    }
}

public class jcy_lc923_3 {
    public int threeSumMulti(int[] A, int target) {
        long[] count = new long[101];
        for (int n : A) count[n] += 1;
        long res = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k > 100 || k < 0) continue;
                if (i == j && j == k)
                    res += count[i] * (count[i] - 1) * (count[i] - 2) / 6;
                else if (i == j && j != k)
                    res += count[i] * (count[i] - 1) / 2 * count[k];
                else if (i < j && j < k)
                    res += count[i] * count[j] * count[k];
            }
        }
        return (int)(res % (1e9 + 7));
    }
}
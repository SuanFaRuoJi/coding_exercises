import java.util.Arrays;

public class jcy_lc923 {
    public int threeSumMulti(int[] A, int target) {
        Arrays.sort(A);
        int mod = 1000000007;
        long res = 0;
        for (int i = 0; i < A.length - 2; i++) {
            int j = i + 1, k = A.length - 1;
            int T = target - A[i];
            while (j < k) {
                if (A[j] + A[k] < T) j += 1;
                else if (A[j] + A[k] > T) k -= 1;
                else {
                    if (A[j] != A[k]) {
                        int left = 1, right = 1;
                        while (j + 1 < k && A[j] == A[j + 1]) {
                            left += 1;
                            j += 1;
                        }
                        while (k - 1 > j && A[k] == A[k - 1]) {
                            right += 1;
                            k -= 1;
                        }
                        res += left * right;
                        res %= mod;
                        j += 1;
                        k -= 1;
                    } else {
                        res += (k - j + 1) * (k - j) / 2;
                        res %= mod;
                        break;
                    }
                }
            }
        }
        return (int)res;
    }
}
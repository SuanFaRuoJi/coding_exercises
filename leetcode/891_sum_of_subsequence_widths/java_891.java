import java.util.Arrays;

public class java_891 {
    public int sumSubseqWidths(int[] A) {
        long mod = 1000000007;
        long[] pows = new long[A.length];
        pows[0] = 1;
        for (int i=1; i<A.length; i++) {
            pows[i] = (pows[i-1] * 2) % mod;
        }

        Arrays.sort(A);

        int l = 0, r = A.length-1;
        long weight = 0, result = 0;

        while (l < r) {
            weight = (weight + (A[r] - A[l])) % mod;
            long quantity = pows[l];
            if (A.length-l-2 > l) {
                quantity = (quantity + pows[A.length-l-2]) % mod;
            }
            long raw = (weight * quantity);
            raw = raw % mod;
            result = (result + raw) % mod;
            l ++;
            r --;
        }
        System.out.println(result);
        return (int)result;
    }
}

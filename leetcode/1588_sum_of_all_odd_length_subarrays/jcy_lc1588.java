public class jcy_lc1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        int[] P = new int[arr.length + 1];
        for (int i = 1; i < P.length; i++)
            P[i] = P[i - 1] + arr[i - 1];
        for (int i = 1; i < P.length; i++)
            for (int j = i - 1; j >= 0; j -= 2)
                res += P[i] - P[j];
        return res;
    }
}
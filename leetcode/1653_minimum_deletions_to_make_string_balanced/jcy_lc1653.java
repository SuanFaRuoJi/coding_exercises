public class jcy_lc1653 {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] countA = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            countA[i] = countA[i + 1];
            if (s.charAt(i) == 'a') countA[i] += 1;
        }
        int count = 0, res = countA[0];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'b') count += 1;
            res = Math.min(res, count + countA[i + 1]);
        }
        return res;
    }
}
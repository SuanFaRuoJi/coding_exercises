public class jcy_lc1566 {
    public boolean containsPattern(int[] arr, int m, int k) {
        int i = 0, j = i + m, count = 0, n = arr.length;
        while (j < n) {
            if (arr[i] != arr[j]) count = 0;
            else {
                count += 1;
                if (count == (k - 1) * m) return true;
            }
            i += 1; j += 1;
        }
        return false;
    }
}
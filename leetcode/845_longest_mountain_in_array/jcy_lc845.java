public class jcy_lc845 {
    public int longestMountain(int[] A) {
        int res = 0, n = A.length, start = 0;
        while (start < n) {
            int end = start;
            if (end < n - 1 && A[end] < A[end + 1]) {
                while (end < n - 1 && A[end] < A[end + 1]) end += 1;
                if (end < n - 1 && A[end] > A[end + 1]) {
                    while (end < n - 1 && A[end] > A[end + 1]) end += 1;
                    res = Math.max(res, end - start + 1);
                }
            }
            start = Math.max(end, start + 1);
        }
        return res;
    }
}
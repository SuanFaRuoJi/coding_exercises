public class jcy_lc1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int left = 0, right = arr.length - 1, n = arr.length, res = 0;
        while (left < n - 1) {
            if (arr[left] > arr[left + 1]) break;
            left += 1;
        }
        while (right > 0) {
            if (arr[right - 1] > arr[right]) break;
            right -= 1;
        }
        if (left == n - 1 || right == 0) return 0;
        res = Math.min(n - 1 - left, right);
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                res = Math.min(res, j - i - 1);
                i += 1;
            } else j += 1;
        }
        return res;
    }
}
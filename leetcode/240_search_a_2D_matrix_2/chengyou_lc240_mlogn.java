public class chengyou_lc240_mlogn {
    // Optimized binary search method, O(MlogN)
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            if (matrix[i][n - 1] < target) continue;
            if (matrix[i][0] > target) return false;
            if (binarySearch(matrix[i], target)) return true;
        }
        return false;
    }

    private boolean binarySearch(int[] A, int target) {
        int left = 0, right = A.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (A[mid] == target) return true;
            else if (A[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}

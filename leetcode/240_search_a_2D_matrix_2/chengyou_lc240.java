public class chengyou_lc240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int rowIdx = m - 1, colIdx = 0;
        while (rowIdx >= 0 && colIdx < n) {
            if (matrix[rowIdx][colIdx] == target) return true;
            else if (matrix[rowIdx][colIdx] < target) colIdx += 1;
            else rowIdx -= 1;
        }
        return false;
    }
}

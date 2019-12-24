public class wsz_java_52 {
    public int totalNQueens(int n) {
        int[] board = new int[n];
        return search(board, 0);
    }

    private int search(int[] board, int row) {
        if (row == board.length) {
            return 1;
        }
        int sum = 0;
        int seed = 1;
        for (int i=0; i < board.length; i++, seed <<= 1) {
            boolean valid = true;
            for (int j = 0; j < row; j++) {
                if (((board[j]&seed)!=0) || (((board[j]<<(row-j))|(board[j]>>(row-j)))&seed)!=0) {
                    valid = false;
                    break;
                }
            }
            if (valid){
                board[row] = seed;
                sum += search(board, row+1);
                board[row] = 0;
            }
        }
        return sum;
    }
}

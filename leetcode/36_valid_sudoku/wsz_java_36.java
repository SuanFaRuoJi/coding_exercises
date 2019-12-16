class wsz_java_36 {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[][] cross = new Set[3][9];
        for (int i=0; i<3; i++) {
            for (int j=0; j<9; j++) {
                cross[i][j] = new HashSet<>();
            }
        }
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char cur = board[i][j];
                if (cur == '.') {
                    continue;
                }
                int val = cur - '0';
                if (cross[0][i].contains(val)) {
                    return false;
                } else {
                    cross[0][i].add(val);
                }
                if (cross[1][j].contains(val)) {
                    return false;
                } else {
                    cross[1][j].add(val);
                }
                if (cross[2][i/3+j/3].contains(val)) {
                    return false;
                } else {
                    cross[2][i/3+j].add(val);
                }
            }
        }
        return true;
    }
}
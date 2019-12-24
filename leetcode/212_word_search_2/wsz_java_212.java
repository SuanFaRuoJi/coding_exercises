import java.util.ArrayList;
import java.util.List;

public class wsz_java_212 {
    public List<String> findWords(char[][] board, String[] words) {
        int height = board.length, width;
        if (height == 0) {
            return new ArrayList<>();
        }
        width = board[0].length;
        List<String> result = new ArrayList<>();
        int[][] cross = new int[height][width];
        for (String word : words) {
            boolean has = false;
            for (int i=0; i<height; i++) {
                for (int j=0; j<width; j++) {
                    cross[i][j] = 1;
                    boolean this_result = search(cross, board, i, j, word, 0);
                    cross[i][j] = 0;
                    if (this_result) {
                        has = true;
                        break;
                    }
                }
                if (has) {
                    break;
                }
            }
            if (has) {
                result.add(word);
            }
        }
        return result;
    }

    private boolean search(int[][] cross, char[][] board, int i, int j, String word, int cur) {
        if (cur == word.length()) {
            return true;
        }
        if (board[i][j] != word.charAt(cur)) {
            return false;
        }
        if (i+1 < board.length && cross[i+1][j] != 1) {
            cross[i+1][j] = 1;
            boolean result = search(cross, board, i+1, j, word, cur+1);
            cross[i+1][j] = 0;
            if (result) {
                return true;
            }
        }
        if (i-1 >= 0 && cross[i-1][j] != 1) {
            cross[i-1][j] = 1;
            boolean result = search(cross, board, i-1, j, word, cur+1);
            cross[i-1][j] = 0;
            if (result) {
                return true;
            }
        }
        if (j+1 < board[0].length && cross[i][j+1] != 1) {
            cross[i][j+1] = 1;
            boolean result = search(cross, board, i, j+1, word, cur+1);
            cross[i][j+1] = 0;
            if (result) {
                return true;
            }
        }
        if (j-1 >= 0 && cross[i][j-1] != 1) {
            cross[i][j-1] = 1;
            boolean result = search(cross, board, i, j-1, word, cur+1);
            cross[i][j-1] = 0;
            if (result) {
                return true;
            }
        }

        return cur+1 == word.length();
    }
}

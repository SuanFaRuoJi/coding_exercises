import java.util.Stack;

public class wsz_85 {
    public int maximalRectangle(char[][] matrix) {
        int height = matrix.length, width;
        if (height == 0) {
            return 0;
        }
        width = matrix[0].length;
        int[][] vectical_histogram = new int[height][width];
        for (int j = 0; j < width; j++) {
            int cumulate = 0;
            for (int i = 0; i < height; i++) {
                if (matrix[i][j] == '1' ) {
                    cumulate ++;
                } else {
                    cumulate = 0;
                }
                vectical_histogram[i][j] = cumulate;
            }
        }

        int max = 0;
        for (int i = 0; i < height; i++) {
            Stack<int[]> s = new Stack<>();
            for (int j = 0; j < width; j++) {
                int cur_height = vectical_histogram[i][j];
                int[] pair = {j, cur_height};
                while (!s.isEmpty() && s.peek()[1] > cur_height) {
                    int[] top = s.pop();
                    int left = s.isEmpty() ? -1 : s.peek()[0];
                    int right = j;
                    int area = top[1] * (right - left - 1);
                    if (area > max) {
                        max = area;
                    }
                }
                s.push(pair);
            }
            int right = width;
            while (!s.isEmpty()) {
                int[] top = s.pop();
                int left = s.isEmpty() ? -1 : s.peek()[0];
                int area = top[1] * (right - left - 1);
                if (area > max) {
                    max = area;
                }
            }
        }
        return max;
    }
}

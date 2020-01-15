public class wsz_java_296 {
    public int minTotalDistance(int[][] grid) {
        int height = grid.length, width, count = 0, x_sum = 0, y_sum = 0, x_half = 0, y_half = 0;
        if (height == 0) {
            return 0;
        }
        width = grid[0].length;
        int[] y_bucket = new int[height], x_bucket = new int[width];
        for (int i=0; i<height; i++) {
            for (int j=0; j<width; j++) {
                if (grid[i][j] == 1) {
                    y_bucket[i] ++;
                    y_sum += i;
                    x_bucket[j] ++;
                    x_sum += j;
                    count ++;
                }
            }
        }
        int acc = 0;
        for (int i=0; i<height; i++) {
            int inc = Math.min((count+1)/2 - acc, y_bucket[i]);
            y_half += inc * i;
            acc += inc;
            if (acc >= (count+1)/2) {
                if (count % 2 == 1) {
                    y_sum += i;
                }
                break;
            }
        }
        for (int i=0; i<width; i++) {
            int inc = Math.min((count+1)/2 - acc, x_bucket[i]);
            x_half += inc * i;
            acc += inc;
            if (acc >= (count+1)/2) {
                if (count % 2 == 1) {
                    x_sum += i;
                }
                break;
            }
        }
        return x_sum - 2*x_half + y_sum - 2*y_half;
    }
}

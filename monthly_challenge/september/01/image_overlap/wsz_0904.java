import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class wsz_0904 {
    public int largestOverlap(int[][] A, int[][] B) {
        List<int[]> pixels = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        int max = 0;
        for (int i=0; i<A.length; i++) {
            for (int j=0; j<A[0].length; j++) {
                if (A[i][j] == 1) {
                    pixels.add(new int[]{i, j});
                }
            }
        }
        for (int i=0; i<B.length; i++) {
            for (int j=0; j<B[0].length; j++) {
                if (B[i][j] == 1) {
                    for (int[] prev : pixels) {
                        int identity = (i - prev[0]) * 103 + (j - prev[1]);
                        int new_val = count.put(identity, count.getOrDefault(identity, 0) + 1) + 1;
                        if (new_val > max) {
                            max = new_val;
                        }
                    }
                }
            }
        }
        return max;
    }
}

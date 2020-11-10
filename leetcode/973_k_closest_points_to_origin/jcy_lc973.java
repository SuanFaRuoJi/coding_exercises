import java.util.Arrays;

public class jcy_lc973 {
    public int[][] kClosest(int[][] points, int K) {
        int left = 0, right = points.length - 1;
        while (left <= right) {
            int mid = partition(points, left, right);
            if (mid == K) break;
            else if (mid < K) left = mid + 1;
            else right = mid - 1;
        }
        return Arrays.copyOfRange(points, 0, K);

    }

    private boolean compare(int[] p1, int[] p2) {
        return p2[0] * p2[0] + p2[1] * p2[1] > p1[0] * p1[0] + p1[1] * p1[1];
    }

    private int partition(int[][] points, int left, int right) {
        int[] pivot = points[right];
        int i = left;
        for (int j = left; j <= right; j++) {
            if (compare(points[j], pivot) == true) {
                int[] temp = points[j];
                points[j] = points[i];
                points[i] = temp;
                i += 1;
            }
        }
        int[] temp1 = points[i];
        points[i] = pivot;
        points[right] = temp1;
        return i;
    }
}
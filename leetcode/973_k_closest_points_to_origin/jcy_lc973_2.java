import java.util.Arrays;

public class jcy_lc973_2 {
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
        return p1[0] * p1[0] + p1[1] * p1[1] < p2[0] * p2[0] + p2[1] * p2[1];
    }

    private int partition(int[][] points, int left, int right) {
        int[] pivot = points[right];
        while (left < right) {
            while (left < right && compare(points[left], pivot)) left += 1;
            points[right] = points[left];
            while (left < right && !compare(points[right], pivot)) right -= 1;
            points[left] = points[right];
        }
        points[left] = pivot;
        return left;
    }
}
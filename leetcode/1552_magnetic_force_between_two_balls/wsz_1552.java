import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class wsz_1552 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int length = position.length-1, right = position[length-1], left = Integer.MAX_VALUE;
        if (m == 2) {
            return right;
        }
        for (int i=1; i<length; i++) {
            if (position[i] - position[i-1] < left) {
                left = position[i] - position[i-1];
            }
        }
        while (left+1 < right) {
            int mid = (left+right) / 2;
            if (search(position, mid, m)) { // can do mid
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean search(int[] positions, int threshold, int m) { // every length is >= threshold, to get smallest possible
        int cur = 0, count = 1;
        while (count < m) {
            int next = cur;
            while (next < positions.length && positions[next] - positions[cur] < threshold) {
                next ++;
            }
            if (next == positions.length) {
                return false;
            }
            count ++;
            cur = next;
        }
        return true;
    }
}

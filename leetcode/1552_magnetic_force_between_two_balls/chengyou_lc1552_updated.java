import java.util.Arrays;

public class chengyou_lc1552_updated {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int left = 0, right = position[n - 1] - position[0];
        if (m == 2) return right;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (countBalls(position, mid) >= m)
                left = mid;
            else right = mid;
        }
        return left;
    }

    private int countBalls(int[] position, int minDist) {
        int res = 1, cur = position[0];
        for (int i = 1; i < position.length; i++) {
            if (position[i] - cur >= minDist) {
                res += 1;
                cur = position[i];
            }
        }
        return res;
    }
}

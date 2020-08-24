public class chengyou_lc1552 {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int left = 0, right = position[n - 1] - position[0];
        while (left < right) {
            int mid = right - (right - left) / 2;
            if (countBalls(position, mid) >= m)
                left = mid;
            else right = mid - 1;
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

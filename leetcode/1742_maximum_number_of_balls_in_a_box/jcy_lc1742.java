public class jcy_lc1742 {
    public int countBalls(int lowLimit, int highLimit) {
        int[] map = new int[46];
        int res = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = sumOfDigits(i);
            map[sum] += 1;
            res = Math.max(res, map[sum]);
        }
        return res;
    }

    private int sumOfDigits(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
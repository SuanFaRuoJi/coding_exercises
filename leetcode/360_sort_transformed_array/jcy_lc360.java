public class jcy_lc360 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int n = nums.length, i = 0, j = n - 1;
        int[] res = new int[n];
        int idx = a >= 0 ? n - 1 : 0;
        while (i <= j) {
            int num1 = calculate(nums[i], a, b, c);
            int num2 = calculate(nums[j], a, b, c);
            if (a >= 0) {
                if (num1 >= num2) {
                    res[idx--] = num1;
                    i += 1;
                }
                else {
                    res[idx--] = num2;
                    j -= 1;
                }
            }
            else {
                if (num1 <= num2) {
                    res[idx++] = num1;
                    i += 1;
                }
                else {
                    res[idx++] = num2;
                    j -= 1;
                }
            }
        }
        return res;
    }

    private int calculate(int x, int a, int b, int c) {
        return a * x * x + b * x + c;
    }
}
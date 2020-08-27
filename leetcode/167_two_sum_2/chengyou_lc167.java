public class chengyou_lc167 {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length, i = 0, j = n - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target)
                return new int[]{i + 1, j + 1};
            else if (numbers[i] + numbers[j] < target)
                i += 1;
            else
                j -= 1;
        }
        return null;
    }
}
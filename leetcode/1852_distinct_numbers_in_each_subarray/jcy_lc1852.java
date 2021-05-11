public class jcy_lc1852 {
    public int[] distinctNumbers(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        int[] map = new int[100001];
        int distinct = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) if (--map[nums[i - k]] == 0) distinct -= 1;
            if (map[nums[i]]++ == 0) distinct += 1;
            if (i >= k - 1) res[i - k + 1] = distinct;
        }
        return res;
    }
}
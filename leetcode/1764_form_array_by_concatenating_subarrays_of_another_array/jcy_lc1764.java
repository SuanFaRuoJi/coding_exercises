public class jcy_lc1764 {
    public boolean canChoose(int[][] groups, int[] nums) {
        int i = 0, start = 0;
        while (i < groups.length && start + groups[i].length <= nums.length) {
            if (helper(groups[i], nums, start)) start += groups[i++].length;
            else start += 1;
        }
        return i == groups.length;
    }

    private boolean helper(int[] group, int[] nums, int start) {
        for (int i = 0; i < group.length; i++)
            if (group[i] != nums[i + start]) return false;
        return true;
    }
}
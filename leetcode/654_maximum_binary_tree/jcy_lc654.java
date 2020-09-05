public class jcy_lc654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;
        int maxIdx = findMaxIdx(nums, start, end);
        TreeNode root = new TreeNode(nums[maxIdx]);
        root.left = helper(nums, start, maxIdx - 1);
        root.right = helper(nums, maxIdx + 1, end);
        return root;
    }

    private int findMaxIdx(int[] nums, int start, int end) {
        int res = -1, max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                res = i;
            }
        }
        return res;
    }
}
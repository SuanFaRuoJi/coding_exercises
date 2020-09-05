public class jcy_lc654_optimized {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        TreeNode[] arr = new TreeNode[nums.length];
        int idx = -1;
        for (int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            while (idx != -1 && arr[idx].val < nums[i])
                curr.left = arr[idx--];
            if (idx != -1)
                arr[idx].right = curr;
            arr[++idx] = curr;
        }
        return arr[0];
    }
}

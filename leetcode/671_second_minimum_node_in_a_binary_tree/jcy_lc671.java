public class jcy_lc671 {
    public int findSecondMinimumValue(TreeNode root) {
        return helper(root, root.val);
    }

    private int helper(TreeNode root, int min) {
        if (root == null) return -1;
        if (root.val > min) return root.val;
        int left = helper(root.left, min), right = helper(root.right, min);
        return (left == -1 || right == -1) ? Math.max(left, right) : Math.min(left, right);
    }
}
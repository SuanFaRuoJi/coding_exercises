public class jcy_lc404_recursive {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }

    private int helper(TreeNode node, boolean isLeft) {
        if (node == null) return 0;
        if (node.left == null && node.right == null)
            return isLeft ? node.val : 0;
        return helper(node.left, true) + helper(node.right, false);
    }
}
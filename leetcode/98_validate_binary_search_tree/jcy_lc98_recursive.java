public class jcy_lc98_recursive {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean helper(TreeNode node, long min, long max) {
        if (node == null) return true;
        int value = node.val;
        if (value <= min || value >= max) return false;
        return helper(node.left, min, value) && helper(node.right, value, max);
    }
}
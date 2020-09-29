public class jcy_lc129_recursive {
    int res = 0;

    public int sumNumbers(TreeNode root) {
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode node, int curSum) {
        if (node != null) {
            curSum = curSum * 10 + node.val;
            if (node.left == null && node.right == null) res += curSum;
            helper(node.left, curSum);
            helper(node.right, curSum);
        }
    }
}

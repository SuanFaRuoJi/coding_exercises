public class jcy_lc250_2 {
    int res = 0;

    public int countUnivalSubtrees(TreeNode root) {
        isUniValue(root, 0);
        return res;
    }

    private boolean isUniValue(TreeNode node, int val) {
        if (node == null) return true;
        if (!isUniValue(node.left, node.val) | !isUniValue(node.right, node.val)) return false;
        res += 1;
        return node.val == val;
    }
}
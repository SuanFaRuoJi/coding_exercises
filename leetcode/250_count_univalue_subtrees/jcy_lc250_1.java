public class jcy_lc250_1 {
    int res = 0;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        isUniValue(root);
        return res;
    }

    private boolean isUniValue(TreeNode node) {
        boolean isUni = true;
        if (node.left != null)
            isUni = isUniValue(node.left) && isUni && node.val == node.left.val;
        if (node.right != null)
            isUni = isUniValue(node.right) && isUni && node.val == node.right.val;
        if (!isUni) return false;
        res += 1;
        return true;
    }
}
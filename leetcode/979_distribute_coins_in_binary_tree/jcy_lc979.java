public class jcy_lc979 {
    int res = 0;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int left = dfs(root.left), right = dfs(root.right);
        res += Math.abs(left) + Math.abs(right);
        return root.val + left + right - 1;
    }
}

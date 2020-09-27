public class jcy_lc112_recursive {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        sum -= root.val;
        if (root.left == null && root.right == null) return sum == 0;
        else return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
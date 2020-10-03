public class jcy_lc298 {
    public int longestConsecutive(TreeNode root) {
        return dfs(root, null, 0);
    }

    private int dfs(TreeNode curr, TreeNode parent, int length) {
        if (curr == null) return length;
        length = (parent != null && curr.val == parent.val + 1) ? length + 1 : 1;
        return Math.max(length, Math.max(dfs(curr.left, curr, length), dfs(curr.right, curr, length)));
    }
}
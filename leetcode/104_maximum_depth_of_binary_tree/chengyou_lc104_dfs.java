public class chengyou_lc104_dfs {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        stack.push(root);
        nums.push(1);
        int res = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int depth = nums.pop();
            res = Math.max(depth, res);
            if (node.left != null) {
                stack.push(node.left);
                nums.push(depth + 1);
            }
            if (node.right != null) {
                stack.push(node.right);
                nums.push(depth + 1);
            }
        }
        return res;
    }
}

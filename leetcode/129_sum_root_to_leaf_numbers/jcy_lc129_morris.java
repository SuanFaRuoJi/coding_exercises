public class jcy_lc129_morris {
    public int sumNumbers(TreeNode root) {
        int res = 0, cur = 0, steps = 0;
        TreeNode predecessor;
        while (root != null) {
            if (root.left != null) {
                predecessor = root.left;
                steps = 1;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                    steps += 1;
                }
                if (predecessor.right == null) {
                    cur = cur * 10 + root.val;
                    predecessor.right = root;
                    root = root.left;
                } else {
                    if (predecessor.left == null) res += cur;
                    for (int i = 0; i < steps; i++) cur /= 10;
                    predecessor.right = null;
                    root = root.right;
                }
            } else {
                cur = cur * 10 + root.val;
                if (root.right == null) res += cur;
                root = root.right;
            }
        }
        return res;
    }
}
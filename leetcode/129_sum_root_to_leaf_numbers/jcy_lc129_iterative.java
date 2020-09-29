import java.util.Stack;

public class jcy_lc129_iterative {
    /*
    public int sumNumbers(TreeNode root) {
        int res = 0, curSum = 0;
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair(root, 0));
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> cur = stack.pop();
            root = cur.getKey();
            curSum = cur.getValue();
            if (root != null) {
                curSum = curSum * 10 + root.val;
                if (root.left == null && root.right == null) {
                    res += curSum;
                } else {
                    stack.push(new Pair(root.right, curSum));
                    stack.push(new Pair(root.left, curSum));
                }
            }
        }
        return res;
    }
     */
}
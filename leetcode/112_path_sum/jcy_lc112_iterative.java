import java.util.Stack;

public class jcy_lc112_iterative {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        nodeStack.add(root);
        sumStack.add(sum - root.val);
        TreeNode curr;
        int curSum = 0;
        while (!nodeStack.isEmpty()) {
            curr = nodeStack.pop();
            curSum = sumStack.pop();
            if (curr.left == null && curr.right == null && curSum == 0) return true;
            if (curr.left != null) {
                nodeStack.add(curr.left);
                sumStack.add(curSum - curr.left.val);
            }
            if (curr.right != null) {
                nodeStack.add(curr.right);
                sumStack.add(curSum - curr.right.val);
            }
        }
        return false;
    }
}
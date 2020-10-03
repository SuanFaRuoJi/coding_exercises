import java.util.Stack;

public class jcy_lc98_inorder {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root, prev = null;
        while (curr != null || !stack.empty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev != null && curr.val <= prev.val)
                return false;
            prev = curr;
            curr = curr.right;
        }
        return true;
    }
}
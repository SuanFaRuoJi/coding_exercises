import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class jcy_lc145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                if (root.right != null) stack.push(root.right);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (!stack.isEmpty() && root.right == stack.peek()) {
                stack.pop();
                stack.push(root);
                root = root.right;
            } else {
                res.add(root.val);
                root = null;
            }
        }
        return res;
    }
}
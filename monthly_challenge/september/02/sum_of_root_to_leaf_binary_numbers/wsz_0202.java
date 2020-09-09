import java.util.HashMap;
import java.util.Stack;

public class wsz_0202 {
    public int sumRootToLeaf(TreeNode root) {
        Stack<TreeNode> q = new Stack<>();
        q.push(root);

        int sum = 0;
        while (!q.isEmpty()) {
            TreeNode cur = q.pop();
            int cur_val = cur.val;
            if (cur.left == null && cur.right == null) {
                sum += cur_val;
            } else {
                if (cur.left != null) {
                    int left_val = cur_val * 2 + cur.left.val;
                    cur.left.val = left_val;
                    q.push(cur.left);
                }
                if (cur.right != null) {
                    cur.right.val = cur_val * 2 + cur.right.val;
                    q.push(cur.right);
                }
            }
        }
        return sum;
    }
}

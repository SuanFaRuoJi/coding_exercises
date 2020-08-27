import java.util.ArrayList;
import java.util.HashMap;

public class wsz_105 {
    class TreeNode { int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            TreeNode[] q = new TreeNode[preorder.length];
            int top = 0;
            HashMap<Integer, Integer> order = new HashMap<>();
            for (int i=0; i<inorder.length; i++) {
                order.put(inorder[i], i);
            }
            TreeNode root = null;
            TreeNode cur = null;
            int i = 0;
            while (true) {
                while (i < preorder.length && (cur == null || order.get(preorder[i]) < order.get(cur.val))) {
                    TreeNode local = new TreeNode(preorder[i]);
                    q[top++] = local;
                    if (cur != null) {
                        cur.left = local;
                    }
                    cur = local;
                    if (root == null) {
                        root = local;
                    }
                    i++;
                }
                if (i == preorder.length) {
                    break;
                }
                while (top != 0 && order.get(cur.val) < order.get(preorder[i])) {
                    cur = q[--top];
                }
                TreeNode right = new TreeNode(preorder[i]);
                cur.right = right;
                q[top++] = right;

                cur = right;
                i++;
            }
            return root;
        }

    }
}

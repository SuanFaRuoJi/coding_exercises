import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class jcy_lc1660_bfs {
    public TreeNode correctBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.right != null) {
                if (cur.right.right != null && visited.contains(cur.right.right.val)) {
                    cur.right = null;
                    return root;
                }
                visited.add(cur.right.val);
                queue.add(cur.right);
            }
            if (cur.left != null) {
                if (cur.left.right != null && visited.contains(cur.left.right.val)) {
                    cur.left = null;
                    return root;
                }
                visited.add(cur.left.val);
                queue.add(cur.left);
            }
        }
        return root;
    }
}

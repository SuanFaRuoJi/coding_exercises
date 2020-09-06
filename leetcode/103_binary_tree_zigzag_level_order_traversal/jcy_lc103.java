import java.util.*;

public class jcy_lc103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        queue.add(root);
        boolean levelIsOdd = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                TreeNode nodeToAdd = null;
                if (levelIsOdd) nodeToAdd = stack.pop();
                else nodeToAdd = new TreeNode(curr.val);
                curLevel.add(nodeToAdd.val);
                if (curr.left != null) {
                    queue.add(curr.left);
                    if (!levelIsOdd) stack.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                    if (!levelIsOdd) stack.add(curr.right);
                }
            }
            res.add(curLevel);
            levelIsOdd = !levelIsOdd;
        }
        return res;
    }
}
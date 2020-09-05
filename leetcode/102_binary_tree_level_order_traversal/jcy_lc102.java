public class jcy_lc102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> stack = new Stack<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> curLevel = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                curLevel.add(curr.val);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null)queue.add(curr.right);
            }
            res.add(curLevel);
        }
        return res;
    }
}
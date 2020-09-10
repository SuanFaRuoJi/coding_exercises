import java.util.*;

public class jcy_lc863 {
    Map<TreeNode, TreeNode> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<>();
        dfs(root, null);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        Set<TreeNode> seen = new HashSet<>();
        seen.add(target);
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (dist == K) {
                for (TreeNode node : queue) res.add(node.val);
                return res;
            }
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                seen.add(curr);
                if (curr.left != null && !seen.contains(curr.left)) {
                    seen.add(curr.left);
                    queue.add(curr.left);
                }
                if (curr.right != null && !seen.contains(curr.right)) {
                    seen.add(curr.right);
                    queue.add(curr.right);
                }
                TreeNode parent = map.get(curr);
                if (parent != null && !seen.contains(parent)) {
                    seen.add(parent);
                    queue.add(parent);
                }
            }
            dist += 1;
        }
        return res;
    }

    private void dfs(TreeNode node, TreeNode parent) {
        if (node != null) {
            map.put(node, parent);
            dfs(node.left, node);
            dfs(node.right, node);
        }
    }
}
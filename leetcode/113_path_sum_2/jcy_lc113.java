import java.util.ArrayList;
import java.util.List;

public class jcy_lc113 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum);
        return res;
    }

    private void helper(TreeNode node, int target) {
        if (node == null) return;
        path.add(node.val);
        if (node.left == null && node.right == null && target == node.val)
            res.add(new ArrayList<>(path));
        else {
            helper(node.left, target - node.val);
            helper(node.right, target - node.val);
        }
        path.remove(path.size() - 1);
    }
}

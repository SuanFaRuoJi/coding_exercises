import java.util.ArrayList;
import java.util.List;

public class jcy_lc366 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode node) {
        if (node == null) return -1;
        int level = 1 + Math.max(helper(node.left), helper(node.right));
        if (res.size() == level) res.add(new ArrayList<>());
        res.get(level).add(node.val);
        return level;
    }
}
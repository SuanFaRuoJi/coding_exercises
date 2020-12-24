import java.util.ArrayList;
import java.util.List;

public class jcy_lc199_dfs {
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return res;
        helper(root, 0);
        return res;
    }

    private void helper(TreeNode node, int level) {
        if (level == res.size()) res.add(node.val);
        if (node.right != null) helper(node.right, level + 1);
        if (node.left != null) helper(node.left, level + 1);
    }
}
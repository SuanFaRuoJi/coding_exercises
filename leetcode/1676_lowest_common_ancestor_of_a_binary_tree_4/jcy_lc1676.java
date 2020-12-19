import java.util.HashSet;
import java.util.Set;

public class jcy_lc1676 {
    Set<Integer> set = new HashSet<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode[] nodes) {
        for (TreeNode node : nodes)
            set.add(node.val);
        return helper(root);
    }

    private TreeNode helper(TreeNode root) {
        if (root == null || set.contains(root.val)) return root;
        TreeNode left = helper(root.left), right = helper(root.right);
        if (left != null && right != null) return root;
        return left != null ? left : right;
    }
}
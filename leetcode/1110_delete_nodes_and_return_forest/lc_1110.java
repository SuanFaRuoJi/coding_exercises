import java.util.ArrayList;
import java.util.List;

public class lc_1110 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode (int x) { val = x; }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        int[] cross = new int[1001];
        for (int i=0; i<to_delete.length; i++) {
            cross[to_delete[i]] ++;
        }
        List<TreeNode> result = traverse(root, true, cross);
        return result;
    }

    private List<TreeNode> traverse(TreeNode root, boolean is_root, int[] cross) {
        if (root == null) {
            return new ArrayList<>();
        }
        int val = root.val;
        List<TreeNode> result = new ArrayList<>();
        if (cross[val] == 0) { // not deleted
            if (is_root) {
                result.add(root);
                is_root = false;
            }
        } else {
            is_root = true;
        }
        result.addAll(traverse(root.left, is_root, cross));
        result.addAll(traverse(root.right, is_root, cross));
        if (root.left != null && cross[root.left.val] != 0) {
            root.left = null;
        }
        if (root.right != null && cross[root.right.val] != 0) {
            root.right = null;
        }
        return result;
    }
}

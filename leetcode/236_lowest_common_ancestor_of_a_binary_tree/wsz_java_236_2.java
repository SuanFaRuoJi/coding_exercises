public class wsz_java_236_2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null){
            return null;
        }
        if (root == p || root == q){
            return root;
        }
        TreeNode l_result = lowestCommonAncestor(root.left, p, q);
        TreeNode r_result = lowestCommonAncestor(root.right, p, q);
        if (l_result != null && r_result != null){
            return root;
        }
        return l_result!=null ? l_result : r_result;
    }
}
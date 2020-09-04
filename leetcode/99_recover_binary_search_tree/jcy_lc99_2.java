public class jcy_lc99_2 {
    TreeNode prev = null, first = null, second = null;

    public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) return;
        inorderTraversal(node.left);
        if (prev != null && prev.val > node.val) {
            second = node;
            if (first == null) first = prev;
            else return;
        }
        prev = node;
        inorderTraversal(node.right);
    }
}
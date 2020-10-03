public class jcy_lc333 {
    public int largestBSTSubtree(TreeNode root) {
        int[] res = largestBST(root);
        return res[2];
    }

    private int[] largestBST(TreeNode node) {
        if (node == null) return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        int[] left = largestBST(node.left), right = largestBST(node.right);
        if (node.val > left[1] && node.val < right[0])
            return new int[]{Math.min(node.val, left[0]), Math.max(node.val, right[1]), left[2] + right[2] + 1};
        else
            return new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[2], right[2])};
    }
}

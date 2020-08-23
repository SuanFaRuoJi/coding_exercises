public class chengyou_lc222 {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int d = depth(root);
        if (d == 0) return 1;
        int left = 1, right = (int)Math.pow(2, d) - 1;
        while (left <= right) {
            int pivot = left + (right - left) / 2;
            if (exists(root, pivot, d)) left = pivot + 1;
            else right = pivot - 1;
        }
        return (int)Math.pow(2, d) - 1 + left;
    }

    private int depth(TreeNode node) {
        int d = 0;
        while (node.left != null) {
            node = node.left;
            d += 1;
        }
        return d;
    }

    private boolean exists(TreeNode node, int idx, int d) {
        int left = 0, right = (int)Math.pow(2, d) - 1;
        for (int i = 0; i < d; i++) {
            int pivot = left + (right - left) / 2;
            if (idx <= pivot) {
                node = node.left;
                right = pivot;
            } else {
                node = node.right;
                left = pivot + 1;
            }
        }
        return node != null;
    }
}

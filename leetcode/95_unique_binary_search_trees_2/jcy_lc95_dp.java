public class jcy_lc95_dp {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode>[] res = new List[n + 1];
        res[0] = new ArrayList<>();
        if (n == 0) return res[0];
        res[0].add(null);
        for (int i = 1; i <= n; i++) {
            res[i] = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                for (TreeNode left : res[j - 1]) {
                    for (TreeNode right : res[i - j]) {
                        TreeNode curr = new TreeNode(j);
                        curr.left = left;
                        curr.right = clone(right, j);
                        res[i].add(curr);
                    }
                }
            }
        }
        return res[n];
    }

    private TreeNode clone(TreeNode node, int offset) {
        if (node == null) return null;
        TreeNode curr = new TreeNode(node.val + offset);
        curr.left = clone(node.left, offset);
        curr.right = clone(node.right, offset);
        return curr;
    }
}
public class jcy_lc99 {
    public void recoverTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderTraversal(root, res);
        int[] swapped = findSwappedElements(res);
        recover(root, swapped[0], swapped[1]);
    }

    private void inorderTraversal(TreeNode node, List<Integer> res) {
        if (node == null) return;
        inorderTraversal(node.left, res);
        res.add(node.val);
        inorderTraversal(node.right, res);
    }

    private int[] findSwappedElements(List<Integer> res) {
        int n = res.size(), first = -1, second = -1;
        for (int i = 1; i < n; i++) {
            if (res.get(i) < res.get(i - 1)) {
                second = i;
                if (first == -1) first = i - 1;
                else break;
            }
        }
        return new int[]{res.get(first), res.get(second)};
    }

    private void recover(TreeNode node, int val1, int val2) {
        if (node == null) return;
        if (node.val == val1 || node.val == val2)
            node.val = node.val == val1 ? val2 : val1;
        recover(node.left, val1, val2);
        recover(node.right, val1, val2);
    }
}
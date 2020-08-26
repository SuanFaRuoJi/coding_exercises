public class chengyou_lc105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        TreeNode root = buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1, map);
        return root;
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                               int[] inorder, int inStart, int inEnd,
                               Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIdx = map.get(root.val);
        int leftNum = inIdx - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + leftNum,
                inorder, inStart, inIdx - 1, map);
        root.right = buildTree(preorder, preStart + leftNum + 1, preEnd,
                inorder, inIdx + 1, inEnd, map);
        return root;
    }
}
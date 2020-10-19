public class jcy_lc1612_optimized {
    public boolean checkEquivalence(Node root1, Node root2) {
        int[] map = new int[26];
        helper(root1, map, 1);
        helper(root2, map, -1);
        for (int val : map)
            if (val != 0) return false;
        return true;
    }

    private void helper(Node root, int[] map, int add) {
        if (root == null) return;
        if (root.val >= 'a' && root.val <= 'z')
            map[root.val - 'a'] += add;
        helper(root.left, map, add);
        helper(root.right, map, add);
    }
}
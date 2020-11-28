public class jcy_lc427 {
    public Node3 construct(int[][] grid) {
        return helper(grid, 0, 0, grid.length);
    }

    private Node3 helper(int[][] grid, int i, int j, int n) {
        if (n == 1) return new Node3(grid[i][j] != 0, true, null, null, null, null);
        Node3 res = new Node3();
        Node3 topLeft = helper(grid, i, j, n / 2);
        Node3 topRight = helper(grid, i, j + n / 2, n / 2);
        Node3 bottomLeft = helper(grid, i + n / 2, j, n / 2);
        Node3 bottomRight = helper(grid, i + n / 2, j + n / 2, n / 2);
        if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf &&
                topLeft.val == topRight.val && topRight.val == bottomLeft.val &&
                bottomLeft.val == bottomRight.val) {
            res.isLeaf = true;
            res.val = topLeft.val;
        } else {
            res.topLeft = topLeft;
            res.topRight = topRight;
            res.bottomLeft = bottomLeft;
            res.bottomRight = bottomRight;
        }
        return res;
    }
}
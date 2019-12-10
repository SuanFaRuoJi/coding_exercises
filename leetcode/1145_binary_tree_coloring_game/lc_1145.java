public class lc_1145 {
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }

     int x_left = 0, x_right = 0;

     public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
         count(root, x);
         int rest = n - x_left - x_right - 1;
         int maximum = Math.max(x_left, Math.max(x_right, rest));
         return maximum > n - maximum;
     }

     private int count (TreeNode root, int x) {
         if (root == null) {
             return 0;
         }
         int left = count(root.left, x), right = count(root.right, x);
         if (root.val == x) {
             x_left = left;
             x_right = right;
         }
         return left + right + 1;
     }
}

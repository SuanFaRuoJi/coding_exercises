public class jcy_lc270 {
    public int closestValue(TreeNode root, double target) {
        TreeNode curr = root;
        double diff = Double.MAX_VALUE;
        int res = root.val;
        while (curr != null) {
            if (curr.val == target) return curr.val;
            if (Math.abs(curr.val - target) < diff) {
                diff = Math.abs(curr.val - target);
                res = curr.val;
            }
            if (curr.val > target) curr = curr.left;
            else curr = curr.right;
        }
        return res;
    }
}
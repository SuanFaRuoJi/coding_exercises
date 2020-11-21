/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class wsz_366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
		search(root, result);
		return result;
    }

	private int search(TreeNode root, List<List<Integer>> result) {
		if (root == null) {
			return 0;
		}

		int height = 0;

		if (root.left != null || root.right != null) {
			height = Math.max(search(root.left, result), search(root.right, result));
		}
		if (height == result.size()) {
			result.add(new ArrayList<>());
		}
		
		result.get(height).add(root.val);
		return height;
	}
}

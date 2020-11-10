/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        TreeNode empty = new TreeNode(0);
		StringBuilder sb = new StringBuilder();
		Queue<TreeNode> q = new ArrayDeque<>();
		q.offer(root);
    	while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			if (cur == empty) {
				sb.append("null");
			} else {
				sb.append(cur.val);
				q.offer(cur.left == null ? empty : cur.left);
				q.offer(cur.right == null ? empty : cur.right);
			}
			sb.append(" ");
		}
		return sb.toString();
	}

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode empty = new TreeNode(0);
        String[] tokens = data.split(" ");
		if (tokens.length == 0) {
			return null;
		}
		if (tokens[0].equals("null")) {
			return null;
		}
		int cursor = 1;
		int root_val = Integer.parseInt(tokens[0]);
		TreeNode root = new TreeNode(root_val);
		Queue<TreeNode> parent = new ArrayDeque<>();
		parent.offer(root);
		while (!parent.isEmpty()) {
			TreeNode cur = parent.poll();
			String raw_left = tokens[cursor++];
			if (!raw_left.equals("null")) {
				int left = Integer.parseInt(raw_left);
				TreeNode left_node = new TreeNode(left);
				cur.left = left_node;
				parent.offer(left_node);
			}
			String raw_right = tokens[cursor++];
			if (!raw_right.equals("null")) {
				int right = Integer.parseInt(raw_right);
				TreeNode right_node = new TreeNode(right);
				cur.right = right_node;
				parent.offer(right_node);
			}
		}
		return root;
	}}

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
			return "";	
		}
		Queue<TreeNode> q = new ArrayDeque<>();
		q.offer(root);

		StringBuilder sb = new StringBuilder();
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			sb.append(cur.val);
			sb.append(' ');
			if (cur.left != null) {
				q.offer(cur.left);
			}
			if (cur.right != null) {
				q.offer(cur.right);
			}
		}

		return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
			return null;
		}

		String[] tokens = data.split(" ");
		TreeNode root = new TreeNode(Integer.parseInt(tokens[0]));
		for (int i=1; i<tokens.length; i++) {
			int cur_val = Integer.parseInt(tokens[i]);
			TreeNode cur_node = new TreeNode(cur_val);
			insert(root, cur_node);
		}
		return root;
    }

	private void insert(TreeNode root, TreeNode to_insert) {
		int root_val = root.val, cur_val = to_insert.val;
		if (cur_val < root_val && root.left == null) {
			root.left = to_insert;
			return;
		} else if (cur_val > root_val && root.right == null) {
			root.right = to_insert;
			return;
		} else {
			insert(cur_val < root_val ? root.left : root.right, to_insert);
		}
	}}

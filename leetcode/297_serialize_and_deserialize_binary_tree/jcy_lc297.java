import java.util.LinkedList;
import java.util.Queue;

public class jcy_lc297 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr == null) sb.append("#").append(" ");
            else {
                sb.append(curr.val).append(" ");
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "") return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        for (int i = 1; i < values.length; i += 2) {
            TreeNode curr = queue.poll();
            if (!values[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                queue.add(left);
                curr.left = left;
            }
            if (!values[i + 1].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i + 1]));
                queue.add(right);
                curr.right = right;
            }
        }
        return root;
    }
}
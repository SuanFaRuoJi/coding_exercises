import java.util.ArrayList;
import java.util.List;

public class jcy_lc655_recursive {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> printTree(TreeNode root) {
        int numRows = getHeight(root), numCols = (int) Math.pow(2, numRows) - 1;
        for (int i = 0; i < numRows; i++) {
            List<String> curRow = new ArrayList<>();
            for (int j = 0; j < numCols; j++) curRow.add("");
            res.add(curRow);
        }
        helper(root, 0, 0, numCols - 1);
        return res;
    }

    private void helper(TreeNode root, int row, int left, int right) {
        if (root == null) return;
        int col = left + (right - left) / 2;
        res.get(row).set(col, String.valueOf(root.val));
        helper(root.left, row + 1, left, col - 1);
        helper(root.right, row + 1, col + 1, right);
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
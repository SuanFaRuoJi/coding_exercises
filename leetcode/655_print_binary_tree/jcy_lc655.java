import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class jcy_lc655 {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null) return res;
        int numRows = getHeight(root);
        int numCols = (int)Math.pow(2, numRows) - 1;
        for (int i = 0; i < numRows; i++) {
            List<String> curRow = new ArrayList<>();
            for (int j = 0; j < numCols; j++) curRow.add("");
            res.add(curRow);
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<int[]> indexQ = new LinkedList<>();
        queue.offer(root);
        indexQ.offer(new int[]{0, numCols - 1});
        int rowIdx = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();
                int[] indices = indexQ.poll();

                int left = indices[0];
                int right = indices[1];
                int mid = left + (right - left) / 2;
                res.get(rowIdx).set(mid, String.valueOf(curr.val));

                if (curr.left != null) {
                    queue.offer(curr.left);
                    indexQ.offer(new int[]{left, mid - 1});
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                    indexQ.offer(new int[]{mid + 1, right});
                }
            }
            rowIdx += 1;
        }
        return res;
    }

    private int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
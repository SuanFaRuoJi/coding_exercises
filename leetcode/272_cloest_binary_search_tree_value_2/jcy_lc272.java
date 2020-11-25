import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class jcy_lc272 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> Math.abs(n1 - target) > Math.abs(n2 - target) ? -1 : 1);
        inorder(root, res, heap, k);
        return new ArrayList<>(heap);
    }

    private void inorder(TreeNode node, List<Integer> res, Queue<Integer> heap, int k) {
        if (node == null) return;
        inorder(node.left, res, heap, k);
        heap.add(node.val);
        if (heap.size() > k) heap.remove();
        inorder(node.right, res, heap, k);
    }
}
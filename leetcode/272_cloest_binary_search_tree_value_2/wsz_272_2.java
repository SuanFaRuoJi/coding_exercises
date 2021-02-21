import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

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
class wsz_272_2 {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        // 1. in-order traversal
		Queue<TreeNode> q = new ArrayDeque<>();
		List<Integer> ordered = new ArrayList<>();
		offer_all(q, root);
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			ordered.add(cur.val);
			offer_all(q, cur);
		}

		int l = binary_search(ordered, target), r = l + 1, count = 0;
		
		List<Integer> result = new ArrayList<>();

		while (count < k && (l >= 0 || r < ordered.size())) {
			int left_diff = l >= 0 ? (target - ordered.get(l)) : Integer.MAX_VALUE;
			int right_diff = r < ordered.size() : (ordered.get(r) - target) : Integer.MAX_VALUE;

			if (left_diff == Integer.MAX_VALUE && right_diff == Integer.MAX_VALUE) {
				break;
			}

			if (left_diff <= right_diff) {
				result.add (ordered.get(l--));
			} else {
				result.add (ordered.get(r++));
			}

			k ++;
		}

		return result;
    }

	private void offer_all(Queue<TreeNode> q, TreeNode cur) {
		while (cur != null) {
			q.offer(cur);
			cur = cur.left;
		}
	}

	private int binary_search(List<Integer> ordered, int needle) {
		int l = 0, r = ordered.size() - 1;
		if (ordered.get(l) > needle) {
			return -1;
		}

		if (ordered.get(r) <= needle) {
			return r;
		}

		while (l+1 < r) {
			int mid = (l+r)/2;
			if  (ordered.get(mid) <= needle) {
				l = mid;
			} else {
				r = mid;
			}
		}

		return l;
	}
}

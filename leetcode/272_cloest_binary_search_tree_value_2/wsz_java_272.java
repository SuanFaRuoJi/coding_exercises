import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class wsz_java_272 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> linear = linearize(root, true), result = new ArrayList<>();
        int l = 0, r = linear.size()-1, counter = 0;
        if (linear.get(l) >= target) {
            for (int i=0; i<k; i++) {
                result.add(linear.get(l+i));
            }
            return result;
        }
        if (linear.get(r) <= target) {
            for (int i=0; i<k; i++) {
                result.add(linear.get(r-i));
            }
            return result;
        }
        while (l+1 < r) {
            int mid = (l+r)/2, cur_val = linear.get(mid);
            if (cur_val >= target) {
                r = mid;
            } else {
                l = mid;
            }
        }
        while(counter++ < k) {
            if (l<=0 || (r<linear.size() && Math.abs(target-linear.get(r)) <= Math.abs(target-linear.get(l)))) {
                result.add(linear.get(r++));
            } else {
                result.add(linear.get(l--));
            }
        }
        return result;
    }

    private List<Integer> linearize(TreeNode root, boolean inc) {
        List<Integer> arr = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null) {
            stack.add(cur);
            cur = inc ? cur.left : cur.right;
        }
        while (!stack.isEmpty()) {
            cur = stack.pop();
            arr.add(cur.val);
            TreeNode next = inc ? cur.right : cur.left;
            while(next != null) {
                stack.add(next);
                next = inc ? next.left : next.right;
            }
        }
        return arr;
    }
}

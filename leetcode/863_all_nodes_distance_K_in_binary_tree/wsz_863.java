import java.util.*;

public class wsz_863 {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> cur = new ArrayList<>(), ans = new ArrayList<>(), comp = dfs(root, cur, target.val);
        dfs(root, comp, ans, 0, comp.size(), K);
        return ans;
    }

    private List<Integer> dfs(TreeNode root, List<Integer> cur, int target) {
        if (root == null) {
            return null;
        }
        if (root.val == target) {
            return new ArrayList<>(cur);
        }
        List<Integer> result;
        cur.add(0);
        result = dfs(root.left, cur, target);
        cur.remove(cur.size()-1);
        if (result != null) {
            return result;
        }
        cur.add(1);
        result = dfs(root.right, cur, target);
        cur.remove(cur.size()-1);
        if (result != null) {
            return result;
        }
        return null;
    }

    private void dfs(TreeNode root, List<Integer> comp, List<Integer> ans, int level, int dist, int limit) {
        if (root == null || level > comp.size() + limit) {
            return;
        }
        if (dist == limit) {
            ans.add(root.val);
        }

        int left_dist = dist, right_dist = dist;
        boolean base = Math.abs(level - comp.size()) == dist;
        if (base) {
            if (level >= comp.size()) {
                left_dist = level - comp.size() + 1;
                right_dist = level - comp.size() + 1;
            } else {
                left_dist += comp.get(level) == 0 ? -1 : 1;
                right_dist += comp.get(level) == 1 ? -1 : 1;
            }
        } else {
            left_dist ++;
            right_dist ++;
        }
        dfs(root.left, comp, ans, level+1, left_dist, limit);
        dfs(root.right, comp, ans, level+1, right_dist, limit);
    }
}

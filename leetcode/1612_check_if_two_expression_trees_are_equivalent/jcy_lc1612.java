import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class jcy_lc1612 {
    public boolean checkEquivalence(Node2 root1, Node2 root2) {
        Map<Character, Integer> map1 = helper(root1), map2 = helper(root2);
        return map1.equals(map2);
    }

    private Map<Character, Integer> helper(Node2 root) {
        Map<Character, Integer> map = new HashMap<>();
        Queue<Node2> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node2 curr = queue.poll();
            if (curr.val != '+')
                map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
            else {
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        return map;
    }
}
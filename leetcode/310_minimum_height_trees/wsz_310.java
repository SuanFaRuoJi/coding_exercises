import java.util.*;

public class wsz_310 {
    class Node {
        List<Integer> edges;
        int maximum, max_arg, max_2;
        HashMap<Integer, Integer> partial_maximum;

        public Node(int size) {
            edges = new ArrayList<>();
            maximum = 0;
            max_arg = -1;
            max_2 = 0;
            partial_maximum = new HashMap<>();
        }
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        if (n == 1) {
            result.add(0);
            return result;
        }
        Node[] nodes = new Node[n];
        for (int i=0; i<edges.length; i++) {
            int from = edges[i][0], to = edges[i][1];
            if (nodes[from] == null) {
                nodes[from] = new Node(n);
            }
            if (nodes[to] == null) {
                nodes[to] = new Node(n);
            }
            nodes[from].edges.add(to);
            nodes[to].edges.add(from);
        }
        for (int i=0; i<n; i++) {
            if (nodes[i].edges.size() == 1) {
                search(nodes, i, -1);
            }
        }
        int min = n;
        for (int i=0; i<n; i++) {
            if (nodes[i].maximum < min) {
                result = new ArrayList<>();
                min = nodes[i].maximum;
            }
            if (nodes[i].maximum == min) {
                result.add(i);
            }
        }
        return result;
    }

    private int search(Node[] nodes, int cur, int prev) {
        Node cur_node = nodes[cur];
        if (cur_node.partial_maximum.size() == cur_node.edges.size()) {
            return prev == cur_node.max_arg ? cur_node.max_2 : cur_node.maximum;
        }

        int maximum = 0;
        for (int next_node : cur_node.edges) {
            if (next_node == prev) {
                continue;
            }
            if (!cur_node.partial_maximum.containsKey(next_node)) {
                int local = search(nodes, next_node, cur);
                if (local > cur_node.maximum) {
                    cur_node.max_2 = cur_node.maximum;
                    cur_node.maximum = local;
                    cur_node.max_arg = next_node;
                } else if (local > cur_node.max_2) {
                    cur_node.max_2 = local;
                }
                cur_node.partial_maximum.put(next_node, local);
            }
            maximum = Math.max(maximum, cur_node.partial_maximum.get(next_node));
        }
        return maximum + 1;
    }

}

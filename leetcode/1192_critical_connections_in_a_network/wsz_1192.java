import java.util.*;

public class wsz_1192 {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] visited_nodes = new int[n];
        int[] uptree = new int[n];
        Arrays.fill(uptree, 0, n, -1);

        List<Integer>[] edges = new List[n];
        Set<Integer> visited_edges = new HashSet<>();

        for (int i=0; i<connections.size(); i++) {
            int from = connections.get(i).get(0), to = connections.get(i).get(1);

            if (edges[from] == null) {
                edges[from] = new ArrayList<>();
            }
            edges[from].add(to);
            if (edges[to] == null) {
                edges[to] = new ArrayList<>();
            }
            edges[to].add(from);
        }

        int[][] hist = new int[n+1][2];
        int hist_length = 0;

        Stack<int[]> stack = new Stack();

        stack.push(new int[]{-1, 0});

        List<List<Integer>> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            int[] top_el = stack.peek();
            int cur = top_el[1], prev = top_el[0];
            // System.out.println(prev + " " + cur);
            stack.pop();

            if (prev != -1 && visited_edges.contains(hash(prev, cur, n))) {
                continue;
            }
            visited_edges.add(hash(prev, cur, n));

            // trim the dead ends;
            while (hist_length > 0 && find(uptree, prev) != find(uptree, hist[hist_length-1][1])) {
                // System.out.println("critical: " + hist[hist_length-1][0] + " " + hist[hist_length-1][1]);
                List<Integer> to_add = new ArrayList<>();
                to_add.add(hist[hist_length-1][1]);
                to_add.add(hist[hist_length-1][0]);
                result.add(to_add);
                hist_length --;
            }

            // clear out related history
            if (visited_nodes[cur] != 0) {
                int top = find(uptree, cur);
                while (hist_length > 0 && visited_nodes[hist[hist_length-1][0]] != 0) {
                    if (cur == hist[hist_length-1][1]) {
                        break;
                    }
                    merge(uptree, hist[hist_length-1][1], top);
                    // System.out.println("redundant: " + hist[hist_length-1][0] + " " + hist[hist_length-1][1]);
                    hist_length --;
                }
                continue;
            }

            if (prev != -1) {
                hist[hist_length++] = top_el;
            }
            visited_nodes[cur] = 1;

            for (int next : edges[cur]) {
                if (!visited_edges.contains(hash(cur, next, n))) {
                    stack.push(new int[]{cur, next});
                }
            }
        }

        for (int i=0; i<hist_length; i++) {
            System.out.println("critical: " + hist[i][0] + " " + hist[i][1]);
            List<Integer> to_add = new ArrayList<>();
            to_add.add(hist[i][1]);
            to_add.add(hist[i][0]);
            result.add(to_add);
        }

        return result;
    }

    private static int hash(int from, int to, int n) {
        return from > to ? (from*(n+1)+to) : (to*(n+1)+from);
    }

    private static int find(int[] uptree, int index) {
        if (uptree[index] == -1) {
            return index;
        }

        int result = find(uptree, uptree[index]);
        uptree[index] = result;
        return result;
    }

    private static void merge(int[] uptree, int from, int to) {
        int from_top = find(uptree, from), to_top = find(uptree, to);
        if (from_top != to_top) {
            uptree[from_top] = to_top;
        }
    }
}

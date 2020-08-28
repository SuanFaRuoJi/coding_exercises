import java.util.*;

public class wsz_1192 {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        int[] uptree = new int[n];
        uptree[0] = 1;

        Stack<int[]> next = new Stack<>(), history = new Stack<>();

        List<List<Integer>> result = new ArrayList<>();

        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> un_critical = new HashSet<>();

        List<Integer>[] edges = new List[n];
        for (List<Integer> cur : connections) {
            if (edges[cur.get(0)] == null) {
                edges[cur.get(0)] = new ArrayList<>();
            }
            edges[cur.get(0)].add(cur.get(1));
            if (edges[cur.get(1)] == null) {
                edges[cur.get(1)] = new ArrayList<>();
            }
            edges[cur.get(1)].add(cur.get(0));
        }

        for (int cur : edges[0]) {
            int[] to_add = {0, cur};
            next.push(to_add);
        }

        while (next.size() != 0) {
            int[] cur = next.pop(); // {a, b} means this iteration we go from a -> b
            if (visited.contains(hash(cur))) {
                continue;
            }
            visited.add(hash(cur));
            //System.out.println(cur[0] + "->" + cur[1]);

            int dest = cur[1], prev = cur[0];
            while (!history.isEmpty() && history.peek()[1] != prev) { // trim the dead end
                history.pop();
            }

            history.push(cur);

            int identifier = uptree[dest];
            if (identifier != 0) { // a cycle
                while (!history.isEmpty()) {
                    int[] to_add = history.pop();
                    un_critical.add(hash(to_add));
                    if (to_add[0] == dest) {
                        break;
                    }
                }
            }

            uptree[dest] = 1;

            for (int cur_next : edges[dest]) {
                int[] to_add = {dest, cur_next};
                if (!visited.contains(hash(to_add))) {
                    next.push(to_add);
                }
            }
        }

        for (List<Integer> cur : connections) {
            if (!un_critical.contains(hash(new int[] {cur.get(0), cur.get(1)}))) {
                result.add(cur);
            }
        }

        return result;
    }

    private int hash(int[] edge) {
        if (edge[0] < edge[1]) {
            return 10000 * edge[0] + edge[1];
        } else {
            return hash(new int[]{edge[1], edge[0]});
        }
    }
}

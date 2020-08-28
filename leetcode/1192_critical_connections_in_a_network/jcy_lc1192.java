import java.util.*;

public class jcy_lc1192 {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (List<Integer> c : connections) {
            graph.putIfAbsent(c.get(0), new ArrayList<>());
            graph.putIfAbsent(c.get(1), new ArrayList<>());
            graph.get(c.get(0)).add(c.get(1));
            graph.get(c.get(1)).add(c.get(0));
        }
        int[] timestamps = new int[n];
        dfs(graph, 0, 0, 1, timestamps, res);
        return res;
    }

    private int dfs(Map<Integer, List<Integer>> graph, int curr, int parent, int currTimestamp, int[] timestamps, List<List<Integer>> res) {
        timestamps[curr] = currTimestamp;
        for (int nextNode : graph.getOrDefault(curr, new ArrayList<Integer>())) {
            if (nextNode == parent) continue;
            if (timestamps[nextNode] > 0)
                timestamps[curr] = Math.min(timestamps[curr], timestamps[nextNode]);
            else
                timestamps[curr] = Math.min(timestamps[curr], dfs(graph, nextNode, curr, currTimestamp + 1, timestamps, res));
            if (currTimestamp < timestamps[nextNode]) res.add(Arrays.asList(curr, nextNode));
        }
        return timestamps[curr];
    }
}
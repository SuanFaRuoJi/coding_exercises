import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class jcy_lc1135 {
    public int minimumCost(int N, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int[] c : connections) {
            graph.get(c[0]).add(new int[]{c[1], c[2]});
            graph.get(c[1]).add(new int[]{c[0], c[2]});
        }
        int cost = 0, numVisited = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{1, 0});
        boolean[] visited = new boolean[N + 1];
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (visited[curr[0]]) continue;
            visited[curr[0]] = true;
            cost += curr[1];
            numVisited += 1;
            for (int[] next : graph.get(curr[0]))
                if (!visited[next[0]]) pq.offer(next);
        }
        return numVisited == N ? cost : -1;
    }
}
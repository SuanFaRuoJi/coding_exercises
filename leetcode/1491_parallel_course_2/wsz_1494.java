import java.util.*;

public class wsz_1494 {
    public int minNumberOfSemesters(int n, int[][] dependencies, int k) {
        int[][] degrees = new int[n+1][2];
        double[] weight = new double[n+1];
        List<Integer>[] out_edges = new List[n+1], in_edges = new List[n+1];
        for (int i=0; i<dependencies.length; i++) {
            int from = dependencies[i][0], to = dependencies[i][1];
            degrees[from][0] ++;
            degrees[to][1] ++;
            if (out_edges[from] == null) {
                out_edges[from] = new ArrayList<>();
            }
            out_edges[from].add(to);
            if (in_edges[to] == null) {
                in_edges[to] = new ArrayList<>();
            }
            in_edges[to].add(from);
        }
        Queue<Integer> q = new LinkedList<>(), cache = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            if (degrees[i][0] == 0) {
                q.offer(i);
            }
            if (degrees[i][1] == 0) {
                cache.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            double frag_weight = degrees[cur][1] == 0 ? 0 : (1 + weight[cur]) / (double)degrees[cur][1];
            if (in_edges[cur] == null) {
                continue;
            }
            for (int edge : in_edges[cur]) {
                degrees[edge][0] --;
                weight[cur] += frag_weight;
                if (degrees[edge][0] == 0) {
                    q.offer(edge);
                }
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (weight[o2] > weight[o1]) {
                    return 1;
                }
                if (weight[o2] == weight[o1]) {
                    return 0;
                }
                if (weight[o2] < weight[o1]) {
                    return -1;
                }
                return 0;
            }
        });
        pq.addAll(cache);
        int res = 0;
        while (!pq.isEmpty()) {
            int limit = Math.min(k, pq.size());
            while (limit != 0) {
                int cur = pq.poll();
                System.out.println(cur);
                if (out_edges[cur] == null) {
                    continue;
                }
                for (int edge : out_edges[cur]) {
                    degrees[edge][1] --;
                    if (degrees[edge][1] == 0) {
                        pq.offer(edge);
                    }
                }
                limit --;
            }
            res ++;
        }
        return res;
    }
}

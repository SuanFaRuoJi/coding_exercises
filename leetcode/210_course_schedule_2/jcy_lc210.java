import java.util.*;

public class jcy_lc210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] numOfIncEdges = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<>();
        buildGraph(numOfIncEdges, edges, prerequisites);
        return bfs(numOfIncEdges, edges);
    }

    private void buildGraph(int[] numOfIncEdges, List<List<Integer>> edges, int[][] prerequisites) {
        int n = numOfIncEdges.length;
        for (int i = 0; i < n; i++) edges.add(new ArrayList<>());
        for (int[] edge : prerequisites) {
            numOfIncEdges[edge[0]] += 1;
            edges.get(edge[1]).add(edge[0]);
        }
    }

    private int[] bfs(int[] numOfIncEdges, List<List<Integer>> edges) {
        int n = numOfIncEdges.length;
        int[] res = new int[n];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (numOfIncEdges[i] == 0) queue.offer(i);
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res[visited] = curr;
            visited += 1;
            for (int next : edges.get(curr)) {
                numOfIncEdges[next] -= 1;
                if (numOfIncEdges[next] == 0) queue.offer(next);
            }
        }
        return visited == n ? res : new int[0];
    }
}
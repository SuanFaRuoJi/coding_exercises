import java.util.LinkedList;
import java.util.Queue;

public class jcy_lc547_bfs {
    public int findCircleNum(int[][] M) {
        int N = M.length, res = 0;
        int[] visited = new int[N];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            if (visited[i] == 0) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int curr = queue.poll();
                    visited[curr] = 1;
                    for (int j = 0; j < N; j++)
                        if (M[curr][j] == 1 && visited[j] == 0) queue.add(j);
                }
                res += 1;
            }
        }
        return res;
    }
}
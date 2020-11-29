import java.util.Arrays;

public class jcy_lc1135_2 {
    public int minimumCost(int N, int[][] connections) {
        int[] parent = new int[N + 1];
        for (int i = 0; i <= N; i++) parent[i] = i;
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        int res = 0;
        for (int[] c : connections) {
            int par1 = find(parent, c[0]);
            int par2 = find(parent, c[1]);
            if (par1 != par2) {
                res += c[2];
                parent[par1] = par2;
                N -= 1;
            }
        }
        return N == 1 ? res : -1;
    }

    private int find(int[] parent, int idx) {
        while (parent[idx] != idx) {
            parent[idx] = parent[parent[idx]];
            idx = parent[idx];
        }
        return idx;
    }
}
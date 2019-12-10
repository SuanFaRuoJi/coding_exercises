public class lc_947 {
    int max = 0;
    int[][] uptree = new int[20001][2];
    public int removeStones(int[][] stones) {
        for (int i=0; i<stones.length; i++) {
            union(stones[i][0]+1, stones[i][1]+10001);
        }
        return max;
    }

    private void union(int a, int b) { // union by rank
        int a_top = find(a), b_top = find(b);
        if (uptree[a_top][1] > uptree[b_top ][1]) {
            uptree[b_top][0] = a_top;
            uptree[a_top][1] += 1 + uptree[b_top][1];
            if (max < uptree[a_top][1]) {
                max = uptree[a_top][1];
            }
        } else {
            uptree[a_top][0] = b_top;
            uptree[b_top][1] += 1 + uptree[a_top][1];
            if (max < uptree[b_top][1]) {
                max = uptree[b_top][1];
            }
        }
    }

    private int find(int a) { // do path compression
        int cur = a;
        while (uptree[cur][0] != 0) {
            cur = uptree[cur][0];
        }
        if (cur != a) {
            uptree[a][0] = cur;
        }
        return cur;
    }
}

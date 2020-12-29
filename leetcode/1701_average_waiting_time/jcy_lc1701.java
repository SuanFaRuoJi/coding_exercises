public class jcy_lc1701 {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double wait = 0, cur = 0;
        for (int[] c : customers) {
            cur = Math.max(cur, (double)c[0]) + c[1];
            wait += cur - c[0];
        }
        return (double)(wait / n);
    }
}
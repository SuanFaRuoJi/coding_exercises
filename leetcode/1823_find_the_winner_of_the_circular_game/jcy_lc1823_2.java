public class jcy_lc1823_2 {
    public int findTheWinner(int n, int k) {
        int res = 0;
        for (int i = 1; i <= n; ++i)
            res = (res + k) % i;
        return res + 1;
    }
}
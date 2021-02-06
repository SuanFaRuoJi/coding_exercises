public class jcy_lc1748 {
    public int sumOfUnique(int[] nums) {
        int[] cnt = new int[101];
        for (int n : nums) cnt[n] += 1;
        int res = 0;
        for (int i = 0; i < 101; i++) if (cnt[i] == 1) res += i;
        return res;
    }
}
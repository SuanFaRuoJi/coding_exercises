public class jcy_lc1806 {
    public int reinitializePermutation(int n) {
        int res = 0, i = 1;
        while (res == 0 || i > 1) {
            if (i < n / 2) i *= 2;
            else i = (i - n / 2) * 2 + 1;
            res += 1;
        }
        return res;
    }
}
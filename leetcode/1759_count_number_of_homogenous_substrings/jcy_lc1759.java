public class jcy_lc1759 {
    public int countHomogenous(String s) {
        int mod = 1000000007, cnt = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) cnt += 1;
            else cnt = 1;
            res = (res + cnt) % mod;
        }
        return res;
    }
}
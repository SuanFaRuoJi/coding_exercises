import java.util.Arrays;

public class jcy_lc828 {
    public int uniqueLetterString(String s) {
        int[][] index = new int[26][2];
        for (int i = 0; i < 26; i++) Arrays.fill(index[i], -1);
        int res = 0, n = s.length(), mod = 1000000007;
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'A';
            res = (res + (i - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod;
            index[c] = new int[]{index[c][1], i};
        }
        for (int c = 0; c < 26; c++)
            res = (res + (n - index[c][1]) * (index[c][1] - index[c][0]) % mod) % mod;
        return res;
    }
}
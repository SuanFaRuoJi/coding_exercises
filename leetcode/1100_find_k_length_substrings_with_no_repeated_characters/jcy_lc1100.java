import java.util.HashSet;
import java.util.Set;

public class jcy_lc1100 {
    public int numKLenSubstrNoRepeats(String S, int K) {
        Set<Character> set = new HashSet<>();
        int res = 0, i = 0;
        for (int j = 0; j < S.length(); ++j) {
            while (set.contains(S.charAt(j)))
                set.remove(S.charAt(i++));
            set.add(S.charAt(j));
            res += j - i + 1 >= K ? 1 : 0;
        }
        return res;
    }
}
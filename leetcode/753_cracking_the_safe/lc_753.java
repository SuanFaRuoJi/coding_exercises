import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class lc_753 {
    private String min = null;
    public String crackSafe(int n, int k) {
        StringBuilder cur = new StringBuilder();
        search(cur, 0, 0, new HashSet<>(), n, k);
        return min;
    }

    private void search(StringBuilder cur, int part, int length, Set<Integer> mapped, int n, int k) {
        if (mapped.size() == Math.pow(k, n)) {
            if (min==null || min.length()>cur.length()) {
                min = cur.toString();
            }
            return;
        }
        for (int i=0; i<k; i++) {
            int new_part = (part * 10) % (int)Math.pow(10, n);
            new_part += i;
            if (length+1<n || !mapped.contains(new_part)) {
                cur.append(i);
                if (length+1>=n) {
                    mapped.add(new_part);
                }
                search(cur, new_part, length+1, mapped, n, k);
                cur.deleteCharAt(cur.length()-1);
                if (length+1>=n) {
                    mapped.remove(new_part);
                }
            }
        }
    }
}

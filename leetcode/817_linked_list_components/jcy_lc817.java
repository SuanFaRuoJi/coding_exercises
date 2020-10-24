import java.util.HashSet;
import java.util.Set;

public class jcy_lc817 {
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet<>();
        for (int n : G) set.add(n);
        ListNode cur = head;
        int res = 0;
        while (cur != null) {
            if (set.contains(cur.val) && (cur.next == null || !set.contains(cur.next.val)))
                res += 1;
            cur = cur.next;
        }
        return res;
    }
}
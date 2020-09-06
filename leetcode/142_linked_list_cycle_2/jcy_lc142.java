import java.util.HashSet;
import java.util.Set;

public class jcy_lc142 {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> visited = new HashSet<>();
        ListNode curr = head;
        while (curr != null && !visited.contains(curr)) {
            visited.add(curr);
            curr = curr.next;
        }
        return curr;
    }
}
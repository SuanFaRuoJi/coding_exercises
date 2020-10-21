import java.util.HashMap;
import java.util.Map;

public class jcy_lc1171 {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0), curr = dummy;
        dummy.next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        int sum = 0;
        while (curr != null) {
            sum += curr.val;
            if (map.containsKey(sum)) {
                curr = map.get(sum).next;
                int key = sum + curr.val;
                while (key != sum) {
                    map.remove(key);
                    curr = curr.next;
                    key += curr.val;
                }
                map.get(sum).next = curr.next;
            } else map.put(sum, curr);
            curr = curr.next;
        }
        return dummy.next;
    }
}
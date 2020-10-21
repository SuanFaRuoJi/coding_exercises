public class jcy_lc1290 {
    public int getDecimalValue(ListNode head) {
        int res = 0;
        ListNode curr = head;
        while (curr != null) {
            res = res * 2 + curr.val;
            curr = curr.next;
        }
        return res;
    }
}
public class jcy_lc1474 {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode curr = head, prev = head;
        while (curr != null) {
            int mCount = m, nCount = n;
            while (curr != null && mCount > 0) {
                prev = curr;
                curr = curr.next;
                mCount -= 1;
            }
            while (curr != null && nCount > 0) {
                curr = curr.next;
                nCount -= 1;
            }
            prev.next = curr;
        }
        return head;
    }
}
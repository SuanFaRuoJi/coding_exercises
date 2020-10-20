public class jcy_lc92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        ListNode curr = head, prev = null;
        int idx = 0;
        while (m > 1) {
            prev = curr;
            curr = curr.next;
            m -= 1; n -= 1;
        }
        ListNode old = prev, tail = curr;
        ListNode next = null;
        while (n > 0) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n--;
        }
        if (old != null) old.next = prev;
        else head = prev;
        tail.next = curr;
        return head;
    }
}
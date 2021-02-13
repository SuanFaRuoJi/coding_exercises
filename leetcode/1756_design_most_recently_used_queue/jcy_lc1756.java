public class jcy_lc1756 {
    ListNode dummy, tail;

    public jcy_lc1756(int n) {
        dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int i = 1; i <= n; i++) {
            curr.next = new ListNode(i);
            curr = curr.next;
        }
        tail = curr;
    }

    public int fetch(int k) {
        ListNode curr = dummy, prev = null;
        for (int i = 0; i < k; i++) {
            prev = curr;
            curr = curr.next;
        }
        if (curr.next == null) return curr.val;
        prev.next = curr.next;
        tail.next = curr;
        curr.next = null;
        tail = curr;
        return curr.val;
    }
}
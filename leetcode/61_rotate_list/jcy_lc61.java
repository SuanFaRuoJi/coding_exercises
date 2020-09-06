public class jcy_lc61 {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode curr = head, fast = head, slow = head;
        int count = 0;
        while (curr != null) {
            count += 1;
            curr = curr.next;
        }
        if (count == 0 || count == 1) return head;
        k = k % count;
        if (k == 0) return head;
        for (int i = 0; i < k; i++)
            fast = fast.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode res = slow.next;
        slow.next = null;
        fast.next = head;
        return res;
    }
}
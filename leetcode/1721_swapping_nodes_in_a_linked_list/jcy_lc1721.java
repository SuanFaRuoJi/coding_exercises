public class jcy_lc1721 {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int n = -1;
        ListNode ptr = dummy;
        while (ptr != null) {
            ptr = ptr.next;
            n += 1;
        }
        ListNode curr = dummy, prev1 = null;
        int cnt1 = k, cnt2 = k;
        while (cnt1-- != 0) {
            prev1 = curr;
            curr = curr.next;
        }
        ListNode fast = dummy, slow = dummy, prev2 = null;
        while (cnt2-- != 0) fast = fast.next;
        while (fast != null) {
            fast = fast.next;
            prev2 = slow;
            slow = slow.next;
        }
        if (n % 2 == 0 && k == n / 2) {
            prev1.next = curr.next;
            curr.next = slow.next;
            slow.next = curr;
        } else if (n % 2 == 0 && k == n / 2 + 1) {
            prev2.next = slow.next;
            prev1.next = curr.next;
            curr.next = prev1;
        } else {
            prev1.next = curr.next;
            curr.next = slow.next;
            slow.next = prev1.next;
            prev2.next = curr;
            prev1.next = slow;
        }
        return dummy.next;
    }
}
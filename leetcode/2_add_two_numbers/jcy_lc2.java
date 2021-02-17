public class jcy_lc2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0), p = l1, q = l2, curr = dummy;
        while (p != null || q != null) {
            int x = 0, y = 0;
            if (p != null) x = p.val;
            if (q != null) y = q.val;
            int curSum = carry + x + y;
            curr.next = new ListNode(curSum % 10);
            carry = curSum / 10;
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) curr.next = new ListNode(carry);
        return dummy.next;
    }
}
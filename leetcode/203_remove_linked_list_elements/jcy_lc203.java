public class jcy_lc203 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        while (curr.next != null) {
            if (curr.next.val == val)
                curr.next = curr.next.next;
            else curr = curr.next;
        }
        return dummy.next;
    }
}
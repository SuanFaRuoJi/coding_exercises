public class jcy_lc82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(head.val == 0 ? 1 : 0);
        dummy.next = head;
        ListNode prev = dummy, curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val != curr.next.val) {
                curr = curr.next;
                prev = prev.next;
            }
            else {
                while (curr.next != null && curr.val == curr.next.val) {
                    if (curr.next.next != null)
                        curr.next = curr.next.next;
                    else curr = curr.next;
                }
                if (curr.next != null) {
                    prev.next = curr.next;
                    curr = curr.next;
                } else prev.next = null;
            }
        }
        return dummy.next;
    }
}
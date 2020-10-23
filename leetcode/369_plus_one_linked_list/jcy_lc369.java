public class jcy_lc369 {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head, notNine = dummy;
        while (curr != null) {
            if (curr.val != 9) notNine = curr;
            curr = curr.next;
        }
        notNine.val += 1;
        notNine = notNine.next;
        while (notNine != null) {
            notNine.val = 0;
            notNine = notNine.next;
        }
        return dummy.val != 0 ? dummy : dummy.next;
    }
}
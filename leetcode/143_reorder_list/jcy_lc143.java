public class jcy_lc143 {
    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prev = null, curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode l1 = head, l2 = prev;
        while (l2.next != null) {
            ListNode temp = l1.next;
            l1.next = l2;
            l1 = temp;
            temp = l2.next;
            l2.next = l1;
            l2 = temp;
        }
    }
}
public class jcy_lc1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode cur1 = list1, cur2 = list1;
        while (b != 0) {
            cur2 = cur2.next;
            if (a != 1) {
                cur1 = cur1.next;
                a -= 1;
            }
            b -= 1;
        }
        cur1.next = list2;
        ListNode ptr = list2;
        while (ptr.next != null) ptr = ptr.next;
        ptr.next = cur2.next;
        return list1;
    }
}
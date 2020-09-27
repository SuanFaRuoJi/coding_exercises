public class jcy_lc109_2 {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ListNode mid = middleNode(head);
        TreeNode node = new TreeNode(mid.val);
        if (head == mid) return node;
        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        return node;
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if (prev != null) prev.next = null;
        return slow;
    }
}

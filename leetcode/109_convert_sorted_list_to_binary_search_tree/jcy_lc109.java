public class jcy_lc109 {
    private ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        int size = getSize(head);
        this.head = head;
        return convertListToBST(0, size - 1);
    }

    private int getSize(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count += 1;
        }
        return count;
    }

    private TreeNode convertListToBST(int l, int r) {
        if (l > r) return null;
        int mid = l + (r - l) / 2;
        TreeNode left = convertListToBST(l, mid - 1);
        TreeNode node = new TreeNode(this.head.val);
        node.left = left;
        this.head = this.head.next;
        node.right = convertListToBST(mid + 1, r);
        return node;
    }
}
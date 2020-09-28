public class jcy_117 {
    Node prev, leftmost;

    public Node connect(Node root) {
        if (root == null) return root;
        leftmost = root;
        Node curr = leftmost;
        while (leftmost != null) {
            prev = null;
            curr = leftmost;
            leftmost = null;
            while (curr != null) {
                processChild(curr.left);
                processChild(curr.right);
                curr = curr.next;
            }
        }
        return root;
    }

    private void processChild(Node child) {
        if (child != null) {
            if (prev != null) prev.next = child;
            else leftmost = child;
            prev = child;
        }
    }
}
public class lc_430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {}

        public Node(int _val,Node _prev,Node _next,Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node flatten(Node head) {
        Node result = flatten_tail(head);
        result.prev.next = null;
        result.prev = null;
        return result;
    }

    private Node flatten_tail(Node head) {
        if (head == null) {
            return null;
        }
        Node pointer = head;
        Node next_head = flatten_tail(head.next); // with prev linked to tail and tail.next linked to head
        Node child_head = flatten_tail(head.child); // with prev linked to tail and tail.next linked to head
        if (child_head != null) { // add child list
            pointer.next = child_head;
            Node child_tail = child_head.prev;
            child_head.prev = pointer;
            pointer = child_tail;
            pointer.next = head;
            head.prev = pointer;
        }
        if (next_head != null) {
            pointer.next = next_head;
            Node next_tail = next_head.prev;
            next_head.prev = pointer;
            pointer = next_tail;
            pointer.next = head;
            head.prev = pointer;
        }
        if (child_head == null && next_head == null) {
            head.next = head;
            head.prev = head;
        }
        head.child = null;
        return head;
    }
}

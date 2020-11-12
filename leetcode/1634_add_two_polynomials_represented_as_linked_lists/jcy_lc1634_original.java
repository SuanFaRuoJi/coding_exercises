public class jcy_lc1634_original {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        if (poly1 == null) return poly2;
        else if (poly2 == null) return poly1;
        PolyNode head1 = poly1, head2 = poly2, dummy = new PolyNode(0, 0), ptr = dummy;
        while (head1 != null || head2 != null) {
            if (head1 != null && head2 != null) {
                if (head1.power == head2.power) {
                    int curCoefficient = head1.coefficient + head2.coefficient;
                    if (curCoefficient != 0) {
                        ptr.next = new PolyNode(curCoefficient, head1.power);
                        ptr = ptr.next;
                    }
                    head1 = head1.next;
                    head2 = head2.next;
                } else if (head1.power > head2.power) {
                    ptr.next = new PolyNode(head1.coefficient, head1.power);
                    head1 = head1.next;
                    ptr = ptr.next;
                } else {
                    ptr.next = new PolyNode(head2.coefficient, head2.power);
                    head2 = head2.next;
                    ptr = ptr.next;
                }
            } else if (head1 == null) {
                ptr.next = head2;
                break;
            } else {
                ptr.next = head1;
                break;
            }

        }
        return dummy.next;
    }
}
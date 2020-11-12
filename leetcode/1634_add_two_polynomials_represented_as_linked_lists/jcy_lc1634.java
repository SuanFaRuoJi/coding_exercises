public class jcy_lc1634 {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode dummy = new PolyNode(), ptr = dummy;
        while (poly1 != null || poly2 != null) {
            int e1 = poly1 == null? -1: poly1.power;
            int e2 = poly2 == null? -1: poly2.power;
            if (e1 == e2) {
                int curCoefficient = poly1.coefficient + poly2.coefficient;
                if (curCoefficient != 0) {
                    ptr.next = new PolyNode(curCoefficient, poly1.power);
                    ptr = ptr.next;
                }
                poly1 = poly1.next;
                poly2 = poly2.next;
            } else if (e1 > e2) {
                ptr.next = new PolyNode(poly1.coefficient, poly1.power);
                poly1 = poly1.next;
                ptr = ptr.next;
            } else {
                ptr.next = new PolyNode(poly2.coefficient, poly2.power);
                poly2 = poly2.next;
                ptr = ptr.next;
            }
        }
        return dummy.next;
    }
}
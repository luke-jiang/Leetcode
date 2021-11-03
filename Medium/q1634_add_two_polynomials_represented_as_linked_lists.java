class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        PolyNode dummy  = new PolyNode();
        PolyNode tail = dummy;
        while (poly1 != null && poly2 != null) {
            if (poly1.power > poly2.power) {
                tail.next = poly1;
                poly1 = poly1.next;
                tail = tail.next;
                tail.next = null;
            } else if (poly1.power < poly2.power) {
                tail.next = poly2;
                poly2 = poly2.next;
                tail = tail.next;
                tail.next = null;
            } else {
                poly1.coefficient += poly2.coefficient;
                if (poly1.coefficient != 0) {
                    tail.next = poly1;
                    poly1 = poly1.next;
                    poly2 = poly2.next;
                    tail = tail.next;
                    tail.next = null;
                } else {
                    poly1 = poly1.next;
                    poly2 = poly2.next;
                }
            }
        }
        if (poly1 != null) tail.next = poly1;
        if (poly2 != null) tail.next = poly2;
        return dummy.next;
    }
}

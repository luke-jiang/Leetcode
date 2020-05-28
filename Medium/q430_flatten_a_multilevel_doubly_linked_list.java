// [LinkedList]

/** You are given a doubly linked list which in addition to the next and previous pointers,
  * it could have a child pointer, which may or may not point to a separate doubly linked list.
  * These child lists may have one or more children of their own, and so on,
  * to produce a multilevel data structure, as shown in the example below.
  * Flatten the list so that all the nodes appear in a single-level, doubly linked list.
  * You are given the head of the first level of the list.
  *
  * Example:
  * head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
  * Output = [1,2,3,7,8,11,12,9,10,4,5,6]
  *   1<->2<->3<->4<->5<->6
  *           |
  *           7<->8<->9<->10
  *               |
  *               11<->12
  */

class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;
        Node end = helper(head);
        // find the head to retun
        while (end.prev != null) end = end.prev;
        return end;
    }

    // recursively flatten the list, return the last
    // node in the list.
    private Node helper(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            if (curr.child == null) {
                prev = curr;
                curr = curr.next;
            } else {
                Node childls = curr.child;
                curr.child = null;
                Node childls_end = helper(childls);
                Node next = curr.next;
                curr.next = childls;
                childls.prev = curr;
                if (next != null) {
                    childls_end.next = next;
                    next.prev = childls_end;
                }
                prev = childls_end;
                curr = childls_end.next;
            }
        }
        return prev;
    }
}

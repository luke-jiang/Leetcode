// [LinkedList]

/** Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. 
  * If the two linked lists have no intersection at all, return null. 
  */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;
        for (ListNode n = headA; n != null; n = n.next) {
            len1++;
        }
        for (ListNode n = headB; n != null; n = n.next) {
            len2++;
        }
        System.out.println(len1);
        System.out.println(len2);
        ListNode shorter = len1 < len2 ? headA : headB;
        ListNode longer  = len1 < len2 ? headB : headA;
        for (int diff = Math.abs(len1 - len2); diff > 0; diff--) {
            longer = longer.next;
        }
        while (shorter != null && longer != null) {
            if (longer == shorter) return longer;
            longer = longer.next;
            shorter = shorter.next;
        }
        return null;
    }
}

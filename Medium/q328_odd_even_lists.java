// [LinkedList]

/** Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, 
  * and return the reordered list.
  * The first node is considered odd, and the second node is even, and so on.
  * Note that the relative order inside both the even and odd groups should remain as it was in the input.
  * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
  *
  * Example 1:
  * Input: head = [1,2,3,4,5]
  * Output: [1,3,5,2,4]
  */

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head;
        ListNode end = head;
        while (end.next != null) end = end.next;
        ListNode tail = end;
        ListNode curr = head;
        while (curr != end) {
            ListNode toMove = curr.next;
            curr.next = toMove.next;
            tail.next = toMove;
            toMove.next = null;
            tail = tail.next;
            curr = curr.next;
            if (toMove == end) break;
        }
        
        return head;
    }
}

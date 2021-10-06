// [LinkedList]

/** Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem 
  * without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
  *
  * Example 1:
  * Input: head = [1,2,3,4,5]
  * Output: [2,1,4,3,5]
  */

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        ListNode tail = swapPairs(next.next);
        next.next = head;
        head.next = tail;
        return next;
    }
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return head;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        
        ListNode i = head;
        ListNode j = head.next;
        
        while (j != null && j.next != null) {
            i.next = j.next;
            j.next = i.next.next;
            i.next.next = j;
            i = j;
            j = i.next;
            
        }
        
        return head.next;
    }
}


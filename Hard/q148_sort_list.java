// [MergeSort]

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode half = medium(head);
        ListNode h1 = sortList(head);
        ListNode h2 = sortList(half);
        return merge(h1, h2);
    }
    
    private ListNode medium(ListNode head) {
        if (head == null || head.next == null) return null;
        
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null) fast = fast.next;
        }
        prev.next = null;
        return slow;
    }
    
    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (h1 != null && h2 != null) {
           if (h1.val <= h2.val) {
               tail.next = h1;
               h1 = h1.next;
           } else {
               tail.next = h2;
               h2 = h2.next;
           }
            tail = tail.next;
            tail.next = null;
        }
        if (h1 != null) tail.next = h1;
        if (h2 != null) tail.next = h2;
        return dummy.next;
    }
    
    private void printList(ListNode n) {
        System.out.print("[");
        for (ListNode i = n; i != null; i = i.next) {
            System.out.print(i.val + ",");
        }
        System.out.println("]");
        
    }
}

// [LinkedList]

/** You are given two non-empty linked lists representing two non-negative integers.
  * The most significant digit comes first and each of their nodes contain a single digit.
  * Add the two numbers and return it as a linked list.
  * You may assume the two numbers do not contain any leading zero, except the
  * number 0 itself.
  *
  * Example:
  * (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4) -> (7 -> 8 -> 0 -> 7)
  *
  * Follow up:
  * What if you cannot modify the input lists? In other words, reversing the lists
  * is not allowed.
  */

class Solution {
    // runtime : O(n)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // find length of two lists.
        int len1 = 0;
        int len2 = 0;
        for (ListNode i = l1; i != null; i = i.next) len1++;
        for (ListNode i = l2; i != null; i = i.next) len2++;

        // dummy head.
        ListNode hd = new ListNode(0);

        ListNode curr1 = l1;
        ListNode curr2 = l2;

        // move the first few nodes in either l1 or l2 to the result
        // list until two lists have the same length.
        while (len1 < len2) {
            ListNode i = new ListNode(curr2.val);
            i.next = hd;
            hd = i;
            curr2 = curr2.next;
            len2--;
        }
        while (len2 < len1) {
            ListNode i = new ListNode(curr1.val);
            i.next = hd;
            hd = i;
            curr1 = curr1.next;
            len1--;
        }

        // add the remaining parts of two lists together.
        while (curr1 != null) {
            ListNode curr = new ListNode(curr1.val + curr2.val);
            curr.next = hd;
            hd = curr;

            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        // update nodes whose value >= 10 by incrementing its next node.
        for (ListNode i = hd; i.next != null; i = i.next) {
            if (i.val >= 10) {
                i.val -= 10;
                i.next.val += 1;
            }
        }

        // dummy head
        ListNode res = new ListNode(-1);

        // reverse the result list.
        while (hd != null) {
            ListNode tmp = hd;
            hd = hd.next;
            tmp.next = res.next;
            res.next = tmp;
        }
        res = res.next;
        return res.val == 0 ? res.next : res;
    }
}

class Solution {
    // use stacks
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // find the shorter/longer lists
        int len1 = 0;
        int len2 = 0;
        for (ListNode n = l1; n != null; n = n.next) len1++;
        for (ListNode n = l2; n != null; n = n.next) len2++;
        ListNode a = len1 >= len2 ? l1 : l2;
        ListNode b = len1 >= len2 ? l2 : l1;
        
        Stack<ListNode> sta = new Stack<>();
        Stack<ListNode> stb = new Stack<>();
        for (ListNode n = a; n != null; n = n.next) sta.push(n);
        for (ListNode n = b; n != null; n = n.next) stb.push(n);
        
        // keep popping nodes from the longer list stack
        // if the shorter list stack is not empty, pop the node and add its value
        // otherwise, add 0
        int carry = 0;
        while (!sta.isEmpty()) {
            ListNode x = sta.pop();
            int y = stb.isEmpty() ? 0 : stb.pop().val;
            x.val += carry + y;
            if (x.val >= 10) {
                carry = 1;
                x.val -= 10;
            } else {
                carry = 0;
            }
        }

        // add a new node as head if carry is not zero
        if (carry == 1) {
            ListNode hd = new ListNode(1);
            hd.next = a;
            a = hd;
        }
        return a;
    }
}

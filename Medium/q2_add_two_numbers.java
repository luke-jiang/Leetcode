// [LinkedList]


/** You are given two non-empty linked lists representing two non-negative integers.
  * The digits are stored in reverse order and each of their nodes contain a single digit.
  * Add the two numbers and return it as a linked list.
  *
  * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
  *
  * Example:
  * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
  * Output: 7 -> 0 -> 8
  * Explanation: 342 + 465 = 807.
  */

class Solution {
    // runtime : O(n)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // input special cases
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode curr1 = l1;
        ListNode curr2 = l2;

        // find the length for each list
        int len1 = 0;
        int len2 = 0;
        while (curr1 != null) {
            len1++;
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            len2++;
            curr2 = curr2.next;
        }

        ListNode smaller = len1 <= len2 ? l1 : l2;
        ListNode larger = len1 > len2 ? l1 : l2;

        // eventually return the longer list as result
        ListNode res = larger;

        // keep adding the values of the shorter list to the longer list
        // while keep track of the carry
        int incr = 0;
        while (true) {
            larger.val += smaller.val + incr;
            incr = larger.val / 10;
            larger.val %= 10;
            if (smaller.next == null) break;
            smaller = smaller.next;
            larger = larger.next;
        }

        // the carry may cause the rest digits of the digits in the longer list
        // to increment larger than 10.
        while (larger.next != null) {
            larger = larger.next;
            larger.val += incr;
            incr = larger.val / 10;
            larger.val %= 10;
        }

        if (incr > 0) larger.next = new ListNode(1);

        return res;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;
        while (n1.next != null && n2.next != null) {
            n1.val += n2.val;
            n1 = n1.next;
            n2 = n2.next;
        }
        n1.val += n2.val;
        if (n1.next == null) {
            n1.next = n2.next;
        }
        ListNode prev = l1;
        ListNode next = l1.next;
        while (prev != null) {
            if (prev.val >= 10) {
                if (next == null) {
                    next = new ListNode(0);
                    prev.next = next;
                }
                prev.val -= 10;
                next.val += 1;
            }
            prev = next;
            if (next != null) next = next.next;
        }
        return l1;
    }
}

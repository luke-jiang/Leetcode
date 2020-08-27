// [LinkedList, PrefixSum]

/** Given the head of a linked list, we repeatedly delete consecutive sequences of
  * nodes that sum to 0 until there are no such sequences.
  * After doing so, return the head of the final linked list.
  * You may return any such answer.
  *
  * (Note that in the examples below, all sequences are serializations of ListNode objects.)
  *
  * Example 1:
  * Input: head = [1,2,-3,3,1]
  * Output: [3,1]
  * Note: The answer [1,2,1] would also be accepted.
  *
  * Example 2:
  * Input: head = [1,2,3,-3,4]
  * Output: [1,2,4]
  *
  * Example 3:
  * Input: head = [1,2,3,-3,-2]
  * Output: [1]
  *
  * Constraints:
  * The given linked list will contain between 1 and 1000 nodes.
  * Each node in the linked list has -1000 <= node.val <= 1000.
  */

class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        Map<Integer, ListNode> map = new HashMap<>();
        int prefix = 0;
        for (ListNode curr = dummy; curr != null; curr = curr.next) {
            prefix += curr.val;
            if (!map.containsKey(prefix)) {
                map.put(prefix, curr);
            } else {
                ListNode prev = map.get(prefix);
                int partSum = prefix;

                for (ListNode i = prev.next; i != curr && i != null; i = i.next) {
                    partSum += i.val;
                    map.remove(partSum);
                }
                prev.next = curr.next;
            }
        }
        return dummy.next;
    }

}

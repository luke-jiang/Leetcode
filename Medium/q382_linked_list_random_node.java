// [LinkedList, Algorithm]

/** Given a singly linked list, return a random node's value from the linked list. 
  * Each node must have the same probability of being chosen.
  */

// Solution 1: Naive ArrayList
class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    List<ListNode> hash;
    public Solution(ListNode head) {
        hash = new ArrayList<>();
        for (ListNode i = head; i != null; i = i.next) {
            hash.add(i);
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int index = (int) (Math.random() * hash.size());
        return hash.get(index).val;
    }
}

// Solution 2: Reservior Sampling Algorithm
// Useful for to do random sampling over a population of unknown size with constant space.
// Sample k elements from a population of unknown size
class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
   ListNode head;
    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int scope = 1;
        int chosenVal = 0;
        for (ListNode curr = head; curr != null; curr = curr.next) {
            if (Math.random() < 1.0 / scope) { // As scope increases, chose prob decreases
                chosenVal = curr.val;
            }
            scope++;
        }
        return chosenVal;
    }
}
// This algorithm guarantees that at any moment, all scanned elements have the same probability
// to be selected. 
// 
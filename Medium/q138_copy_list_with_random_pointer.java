// [LinkedList, Map]

/** A linked list is given such that each node contains an additional random pointer
  * which could point to any node in the list or null.
  * Return a deep copy of the list.
  * The Linked List is represented in the input/output as a list of n nodes. Each
  * node is represented as a pair of [val, random_index] where:
  *     val: an integer representing Node.val
  *     random_index: the index of the node (range from 0 to n-1) where random pointer
  *     points to, or null if it does not point to any node.
  */

class Solution {
    public Node copyRandomList(Node head) {
        // original node -> copied node
        Map<Node, Node> map = new HashMap<>();
        Node nhead = new Node(-1, null, null);
        Node end = nhead;
        for (Node curr = head; curr != null; curr = curr.next) {
            int val = curr.val;
            Node n = new Node(val, null, null);
            end.next = n;
            end = n;

            map.put(curr, n);
        }

        nhead = nhead.next;
        Node curr1 = nhead;

        for (Node curr = head; curr != null; curr = curr.next) {
            if (curr.random != null) {
                curr1.random = map.get(curr.random);
            }
            curr1 = curr1.next;

        }
        return nhead;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node dummy = new Node(0);
        Node end = dummy;
        for (Node n = head; n != null; n = n.next) {
            Node newNode = new Node(n.val);
            map.put(n, newNode);
            end.next = newNode;
            end = end.next;
        }
        Node n1 = head;
        Node n2 = dummy.next;
        while (n1 != null && n2 != null) {
            n2.random = map.getOrDefault(n1.random, null);
            n1 = n1.next;
            n2 = n2.next;
        }
        return dummy.next;
    }
}

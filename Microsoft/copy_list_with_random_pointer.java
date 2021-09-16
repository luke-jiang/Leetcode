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

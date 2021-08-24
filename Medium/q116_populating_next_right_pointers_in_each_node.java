class Solution {
    public Node connect(Node root) {
        Node head = root;
        while (head != null) {
            Node nextHead = new Node(0);
            Node nextTail = nextHead;
            for (Node node = head; node != null; node = node.next) {
                if (node.left != null) {
                    nextTail.next = node.left;
                    nextTail = node.left;
                }
                if (node.right != null) {
                    nextTail.next = node.right;
                    nextTail = node.right;
                }
            }
            head = nextHead.next;
        }

        return root;
    }
}

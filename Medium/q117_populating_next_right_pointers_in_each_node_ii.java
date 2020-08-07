// [Tree, LinkedList] ***

/** Given a binary tree

      struct Node {
        int val;
        Node *left;
        Node *right;
        Node *next;
      }
  * Populate each next pointer to point to its next right node. If there is no next
  * right node, the next pointer should be set to NULL.
  * Initially, all next pointers are set to NULL.
  *
  * Follow up:
  * You may only use constant extra space.
  * Recursive approach is fine, you may assume implicit stack space does not count as
  * extra space for this problem.
  *
  * Example:
  * Input: root = [1,2,3,4,5,null,7]
  * Output: [1,#,2,3,#,4,5,7,#]
  * Explanation: Given the above binary tree (Figure A), your function should populate each
  * next pointer to point to its next right node, just like in Figure B. The serialized output
  * is in level order as connected by the next pointers, with '#' signifying the end of each level.
  */


class Solution {
    // use the next pointer to go from the left subtree to the right subtree
    // construct next lists level by level
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

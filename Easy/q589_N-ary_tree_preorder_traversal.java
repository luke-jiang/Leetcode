// [Tree Traversal]

/** Given an n-ary tree, return the preorder traversal of its nodes' values.
  * Nary-Tree input serialization is represented in their level order traversal,
  * each group of children is separated by the null value (See examples).
  */

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        if (root == null) {
            return res;
        }
        st.push(root);
        while (!st.isEmpty()) {
            Node curr = st.pop();
            res.add(curr.val);
            for (int i = curr.children.size() - 1; i >= 0; i--) {
                st.push(curr.children.get(i));
            }
        }

        return res;
    }
}

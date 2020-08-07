// [Tree] ***

/** Serialization is the process of converting a data structure or object into a sequence
  * of bits so that it can be stored in a file or memory buffer, or transmitted across a
  * network connection link to be reconstructed later in the same or another computer
  * environment.
  * Design an algorithm to serialize and deserialize a binary tree. There is no restriction
  * on how your serialization/deserialization algorithm should work. You just need to ensure
  * that a binary tree can be serialized to a string and this string can be deserialized to
  * the original tree structure.
  *
  * Example:
  * You may serialize the following tree:

        1
       / \
      2   3
         / \
        4   5

  * as "[1,2,3,null,null,4,5]"
  *
  * Clarification: The above format is the same as how LeetCode serializes a binary tree.
  * You do not necessarily need to follow this format, so please be creative and come up
  * with different approaches yourself.
  *
  * Note: Do not use class member/global/static variables to store states. Your serialize
  * and deserialize algorithms should be stateless.
  *
  */

public class Codec {
    // use BFS order as serialize order.

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.remove();
            if (curr == null) {
                sb.append("n,");    // null node
            } else {
                sb.append(curr.val + ",");
                q.add(curr.left);
                q.add(curr.right);
            }
        }

        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("")) return null;

        String[] nodes = data.split(",");

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.add(root);
        int index = 1;
        while (index < nodes.length) {
            TreeNode curr = q.remove();
            String lval = nodes[index];
            index++;
            String rval = nodes[index];
            index++;
            if (!lval.equals("n")) {
                TreeNode left = new TreeNode(Integer.parseInt(lval));
                curr.left = left;
                q.add(left);
            }
            if (!rval.equals("n")) {
                TreeNode right = new TreeNode(Integer.parseInt(rval));
                curr.right = right;
                q.add(right);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

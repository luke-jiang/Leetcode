/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        int len1 = 0;
        int len2 = 0;
        for (Node n = p; n != null; n = n.parent) len1++;
        for (Node n = q; n != null; n = n.parent) len2++;
        Node longer = len1 >= len2 ? p : q;
        Node shorter = len1 >= len2 ? q : p;
        for (int i = 0; i < Math.abs(len1 - len2); i++) {
            longer = longer.parent;
        }
        while (longer != shorter) {
            longer = longer.parent;
            shorter = shorter.parent;
        }
        return longer;
    }
}

class Solution {
    public Node cloneGraph(Node node) {
        Node[] nodes = new Node[101];
        // nodes[1] = node;
        return dfs(nodes, node);
    }

    private Node dfs(Node[] nodes, Node node) {
        if (node == null) return null;

        int val = node.val;
        if (nodes[val] != null) {
            return nodes[val];
        } else {
            Node curr = new Node(val);
            nodes[val] = curr;
            for (Node neibor : node.neighbors) {
                curr.neighbors.add(dfs(nodes, neibor));
            }
            return curr;
        }
    }
}

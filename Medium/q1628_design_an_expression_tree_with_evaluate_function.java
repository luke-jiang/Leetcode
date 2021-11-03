/**
 * This is the interface for the expression tree Node.
 * You should not remove it, and you can define some classes to implement it.
 */

abstract class Node {
    public abstract int evaluate();
    // define your fields here
};

class OpNode extends Node {
    Character op;
    Integer val;
    Node left;
    Node right;
    
    public OpNode(Character op, Node left, Node right) {
        this.op = op; this.val = null; this.left = left; this.right = right;
    }
    
    public OpNode(Integer val) {
        this.op = null; this.val = val; this.left = null; this.right = null;
    }
    
    @Override
    public int evaluate() {
        if (val != null) {
            return val;
        }
        int x = left.evaluate();
        int y = right.evaluate();
        if (op == '+') {
            return x + y;
        } else if (op == '-') {
            return x - y;
        } else if (op == '*') {
            return x * y;
        } else if (op == '/') {
            return x / y;
        } else {
            return 0;
        }
    }
};

/**
 * This is the TreeBuilder class.
 * You can treat it as the driver code that takes the postinfix input 
 * and returns the expression tree represnting it as a Node.
 */

class TreeBuilder {
    Stack<String> st;
    Node buildTree(String[] postfix) {
        st = new Stack<>();
        for (String s : postfix) st.add(s);
        return get();
    }
    
    private Node get() {
        String s = st.pop();
        char op = s.charAt(0);
        if (op == '+' || op == '-' || op == '*' || op == '/') {
            Node rhs = get();
            Node lhs = get();
            return new OpNode(op, lhs, rhs);
        } else {
            return new OpNode(Integer.parseInt(s));
        }
    }
};


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
 
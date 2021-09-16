

## Trie:
Trie is best used for solving ... kinds of problems. **q208_implement_trie** implements a basic trie data structure and the essential interface: `insert` and `search`.

## Backtracking & Combinationals:
The backtracking and combinational problems have the following pattern: give a set of candidates S, draw k elements out of S with/without replacement. Find all possible results. The output set may be required to remove duplicate combinations. **q39_combination_sum** gives the basic pattern to this kind of problems and **q39_combination_sum_ii** describes the technique of avoiding including duplicates to the result.

## Tree Traversal:
In-order traversal using stack **q230_kth_smallest_number_in_bst** and **q94_binary_tree_in_order_traversal** and q98

Pre-order traversal using stack:
```java
Stack<TreeNode> st = new Stack<>();
st.push(root);
// first, add all nodes in left-most path
while (root.left != null) {
  st.push(root.left);
  root = root.left;
}
while (!st.isEmpty()) {
  // the nodes are popped in pre-order
  TreeNode next = st.pop();
  // if node has RST, add all nodes in left-most path of that RST
  TreeNode tmp = next.right;
  while (tmp != null) {
    st.push(tmp);
    tmp = tmp.left;
  }
}
```

Level order traversal using queue (Tree BFS):
For each outer iteration, the nodes in the queue belong to the same depth (level) of the tree.
```java
Queue<TreeNode> q = new LinkedList<>();
q.add(root);
while (!q.isEmpty()) {
  int size = q.size();
  for (int i = 0; i < size; i++) {
    TreeNode next = q.remove();
    ...
    if (n.left != null) q.add(next.left);
    if (n.right != null) q.add(next.right);
  }
}
```



## Monotonic Stack:
Monotonic stack is useful to find the first left/right greater/smaller element of another element in an unsorted array. The stack stores the indices of candidates. A typical monotonic stack looks like this:

```java
Stack<Integer> stack = new Stack<>();
for (int i = 0; i < len; i++) {
  while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
    res[stack.pop()] = nums[i];
  }
}
```

When traversing each element in the unsorted array, the stack keeps popping all indices whose values are smaller/larger than that element, until it meets an index whose index is larger/smaller, or the stack becomes empty. Then, the algorithm adds the current index into the stack.

q739_daily_temperatures
q503_next_greater_element_ii
q907_sum_of_subarray_sums

## Binary Search

## Binary Search Tree
A binary search tree is a binary tree that satisfies the following condition:
1. all nodes in a node n's LST (left sub-tree) is smaller than the node's value.
2. all nodes in a node n's RST (right sub-tree) is larger than the node's value.
The natural order of a BST is pre-order traversal. One can use a stack to perform pre-order traversal.

## DP
The key rationale of the solution to a DP problem is its *recurrent relation*. Mathematically, recurrent relation defines how the answer to a big problem is related to the answers to sub-problems.


# Arrays
## Prefix Sum
Given an input array A, a prefix sum of A is another array B, where B[i] := sum { 0 <= j <= i, A[j] }. Prefix sum is useful when we want to find

Problems:
- q560_subarray_sum_equals_k
- q238_product_of_array_except_self


accumulation
  sum, prod, max/min

## Sliding Window / Two Pointers

# Strings
## String Compression
String compression transforms a string into the form of `[char][int]+`, representing how many times a character repreats itself. E.g. `aabbc` can be converted into `a2b2c1`.

Related Problems:
- q443_string_compression
- q809_expressive_words
- q696_count_binary_substrings

# Binary Trees
Binary tree is a tree data structure in which each node has at most 2 children, which are referred to as the left child and the right child. The following snippet shows the definition of a binary `TreeNode` in leetcode questions:
```java
 public class TreeNode {
    int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
 ```
## Tree Traversal:
Unlike linear data structures where there is a unique way to traverse all elements in the data structure, a binary tree can be traversed in multiple ways. Depending on the relation between the left subtree, the right subtree, and the root, a binary tree can be traversed in the following 3 ways:
- **In-order traversal**: [left, root, right]
- **Pre-order traversal**: [root, left, right]
- **Post-order traversal**: [left, right, root]

Besides these, it is also common to see a **level-order traversal**, which is synonymous to a BFS.

### In-order traversal w/ stack:
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

Another compact template of in-order traversal with stack:
```java
Stack<TreeNode> stack = new Stack<>();
TreeNode curr = root;
while (curr != null || !stack.isEmpty()) {
    while (curr != null) {
        stack.push(curr);
        curr = curr.left;
    }
    curr = stack.pop();
    res.add(curr.val);
    curr = curr.right;
}
return res;
```
Related Problems:
- q230_kth_smallest_number_in_bst
- q94_binary_tree_in_order_traversal
- q98_validate_binary_search_tree

### Level order traversal w/ queue (Tree BFS):
Level order traversal ensures that nodes located at level i are traversed before nodes at level i+1. The following template shows an implementation of level order traversal using queue. For each level, the nodes are traversed from left to right.

```java
Queue<TreeNode> q = new LinkedList<>();
q.add(root);
while (!q.isEmpty()) {
  int size = q.size();
  // nodes in the for loop belong to the same level.
  for (int i = 0; i < size; i++) {
    TreeNode next = q.remove();
    ...
    if (n.left != null) q.add(next.left);
    if (n.right != null) q.add(next.right);
  }
}
```

## Parent Map
Parent map is an auxiliary data structure usually used for problems that require knowing the parent node of a tree node.
```java
// use a global hashmap for parent map
Map<TreeNode, TreeNode> parents;

// populate parent map recursively
private void setParents(TreeNode root, TreeNode parent) {
  if (root == null) return;
  parents.put(root, parent);
  setParents(root.left, root);
  setParents(root.right, root);
}
```

Related Problems:
- q236_lowest_common_ancestor_of_a_binary_tree
- q863_all_nodes_distance_k_in_binary: parent map and BFS
- q1110_delete_nodes_and_return_forest: parent map and BST


## Trie:
Trie is best used for solving ... kinds of problems. **q208_implement_trie** implements a basic trie data structure and the essential interface: `insert` and `search`.

# Graphs
## Critical Edge
A critical edge of a graph is such an edge that, if removed, would disconnect the whole graph. The algorithm for finding critical edges of a graph is inspired by Tarjan's strongly connected component problem. The key intuitions are thr following:
1. An edge that belongs to a loop cannot be a critical edge. This transforms the problem into edge detection. We can use DFS to detect back edges indicating loops.
2. Once we have detected a back edge, we want to mark all other edges in the loop to be non-critical. This can be done by using a timestamp recording when each node is traversed. We annotate the DFS algorithm to return the minimum timestamp discovered while traversing the neighbors. If a neighbor's minimal timestamp is lesser than the node's timestamp, then we know such an edge must be non-critical.
```java
private int dfs(int parent, int node, int[] timestamps) {
    if (timestamps[node] != 0) { // node already traversed
        return timestamps[node];
    }
    timestamps[node] = T++;

    int minStamp = Integer.MAX_VALUE;
    for (int neighbor : graph[node]) {
        if (neighbor == parent) continue; // skip the parent

        int neighborStamp = dfs(node, neighbor, timestamps);
        minStamp = Math.min(minStamp, neighborStamp);
    }

    if (minStamp >= timestamps[node]) {
        if (parent > -1) {
            res.add(Arrays.asList(parent, node));
        }
    }

    return Math.min(timestamps[node], minStamp);
}
```

Related Problems:
- q1192_critical_connections_in_a_network




## Heap / Priority Queue



## Backtracking & Combinationals:
The backtracking and combinational problems have the following pattern:  
Given a set of candidates S, draw k elements out of S with/without replacement. Find all possible results.  
The output set may be required to remove duplicate combinations. **q39_combination_sum** gives the basic pattern to this kind of problems and **q39_combination_sum_ii** describes the technique of avoiding including duplicates to the result.



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

Questions:
- q31_next_greater_element_i: a classical application of monotonic stack
- q503_next_greater_element_ii: a variation of the monotonic stack template, traverse the array twice (circular)
- q739_daily_temperatures: basic application of monotonic stack
- q907_sum_of_subarray_sums

## Binary Search
Binary Search is used to search an element in a sorted array. The following template shows an iterative implementation of binary search. The search region is marked by two pointers `low` and `high`. `low` is initialized as the starting index `0` and `high` is initialized as the last index `arr.length-1`. The search ends with `low` is strictly larger than `high`, indicating that the target is not found. At each iteration, we calculate the medium index `mid`, and update `low` and `high` accordingly.

The runtime of binary search is O(logn), because at each iteration we cut the search space half in size.
```java
// `low` and `high` mark the search region [low, high] 
int low = 0;
int high = arr.length - 1;
while (low <= high) {
  // formula for calculating `mid`
  int mid = low + (high - low) / 2;
  if (arr[mid] == target) {
    return true;
  } else if (target > arr[mid]) {
    low = mid + 1;
  } else {
    high = mid - 1;
  }
}
return false;
```

## Binary Search Tree
A binary search tree is a binary tree that satisfies the following condition:
1. all nodes in a node n's LST (left sub-tree) is smaller than the node's value.
2. all nodes in a node n's RST (right sub-tree) is larger than the node's value.
The natural order of a BST is in-order traversal. One can use a stack to perform in-order traversal.

## DP
Dynamic programming is a method to solve a particular type of problem: The answer to a larger problem is dependent on answers to smaller problems, which are subset to the larger problem. In other words, given a problem P of size i, we can efficiently find its answer by

The key rationale of the solution to a DP problem is its *recurrent relation*. Mathematically, recurrent relation defines how the answer to a big problem is related to the answers to sub-problems.

### Iterative DP:

### Recursive DP:
Recursive DP implements the recurrent relation recursively. One advantage of this implementation is that the recurrent relation is clearly encoded in the recursive *search* function. The following pseudocode shows a structure of a recursive search on a 2d DP problem:
```Java
int[][] dp;

private int search(int i, int j, ...) {
  if (cond1) {
    dp[i][j] = f_1(search(i_1, j_j))
  } else if (cond2) {
    dp[i][j] = f_2(search(i_2, j_2))
  } else ...
}
```

### DP Variation 1: Reduced DP
In this case, the answer to the current problem is not dependent on all previous answers, but only a single previous answer or some state (e.g. max/min) about the previous answers. In this case, the dp cache array can be reduced to variables.

### DP Variation 2: Multiple Caches
In this case, the answer to the current problem depends on multiple (usually two) types of previous answers.

Problems:
- q322_coin_exchange
- q139_word_break







## Reduction Search
Reduction search is a generalization of binary search. Similar to binary search, we have two pointers marking the boundary of the search space (i.e., sub-problem). However, at each step, we do not necessarily reduce the search space by half. The reduction can be more general.

Problems:
- q680_valid_palindrome_ii
- q42_trapping_rain_water




## In-place Marking

Problems:
- q287_find_the_duplicate_number

## Bit Manipulation
Basic bitwise operators: &, |, ~, ^
properties of xor: 0^x = x, x^x = 0, x^y = y^x






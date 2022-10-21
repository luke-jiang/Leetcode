# Array
## Array Techniques:
### Prefix Sum
Given an input array A, a prefix sum of A is another array B, where B[i] := sum { 0 <= j <= i, A[j] }. Prefix sum is useful when we want to find

Problems:
- q560_subarray_sum_equals_k
- q238_product_of_array_except_self


accumulation
  sum, prod, max/min

### Value Map
Given an array A, one can build a value map that maps each element to its index.


### Monotonic Stack
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

# Linked List
A linked list is a sequence of list nodes, each contains a pointer to the next list node in the list. The first list node in the list is called the *head*, and the last node is called the *tail*. Unlike arrays that permits random access, one can only traverse a linked list from the head of the list. The following snippet shows the definition of a `ListNode` in leetcode questions:
```java
// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
```
Besides singly-linked list, it is also common to see the following two types of linked list:
- doubly linked list: where each node contains a *next* as well as a *prev* pointer, which points to the previous node. It is convenient and customary to use dummy nodes for the `head` and `tail` of a doubly-linked list.
- circular linked list: the `next` pointer of the tail node points to the head node instead of being null.

## Linked List Techniques:
- **Dummy head**: when constructing a new linked list, it is convenient to first create a dummy head node to kickstart list creation. The dummy node holds no useful data, as it only serves as an access point to the real list nodes. Using a dummy head relieves us from dealing with the edge case of inserting into an empty list. When list construction is completed, we return `dummy.next` as the real head node of the result list.
- **Previous pointer**: to delete a non-head node in a linked list, we must have access to its previous node, and set the `next` pointer of the previous node to the next node of the node to be deleted. Thus, we must use a pointer to keep track of the previous node when we are searching a node to be deleted.
- **Reverse order stack**: If we put list nodes iteratively into a stack, `stack.pop` will generates an inverse node order. This technique requires O(N) time and space.
- **Interval pointers**: we can use this technique to access N-th node from the tail. First, create two pointers `from` and `to`, and move `to` to the N-th node from the head. Then, move `from` and `to` together until `to` points to the tail node. As a result, `from` now points to the N-th node from the tail. This technique requires O(N) time and O(1) space.
  - 19
- **Slow-Fast pointer**: similar to the slow-fast pointer technique for arrays, we keep two pointers `slow` and `fast`. For each time `slow` moves one step, `fast` will move two steps. This technique is particularly useful for cycle detection, where `fast` will eventually catch up with `slow`. It is also useful to find the midpoint of the linked list: when `fast` reached the tail, `slow` will points to the middle of the list.
- **Change the value**: keep in mind that the `val` of a list node could be changed! Sometimes a quesiton may disallowing this, as using this technique would greatly simplify the solution. However, if the question imposes no such constraint, changing `val` might be the unique solution.

# Binary Tree
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
- **In-order traversal**: left, root, right
- **Pre-order traversal**: root, left, right
- **Post-order traversal**: left, right, root

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

### In-order Traversal (Recursion):
Besides using stack, one can also use a recursive approach:
```java
public List<Integer> inorderTraversal(TreeNode root) {
  return helper(root, new ArrayList<>());
}

private List<Integer> helper(TreeNode root, List<Integer> ls) {
  if (root == null) return ls;
  List<Integer> t = helper(root.left, ls);
  t.add(root.val);
  return helper(root.right, t);
}
```

### Level order traversal w/ queue (Tree BFS):
Level order traversal ensures that nodes located at level `i` are traversed before nodes at level `i+1`. The following template shows an implementation of level order traversal using queue. For each level, the nodes are traversed from left to right.

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
## Binary Tree Techniques:
### Parent Map:
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

# Binary Search Tree
Binary search tree is a binary tree with the following additional constraints:

1. All nodes in the left subtree are smaller than the root
2. All nodes in the right subtree are larger than the root

To search a value in a BST, one can iteratively compare the node value with the target. If the node value is the same as the target, then we have found the target successfully. If the node value is smaller than the target, then the target must be in the RST. Otherwise, the target must be in thr LST.

Note that the in-order traversal of a BST gives the sorted order of the elements in BST. One can use a stack to implement in-order traversal.


Related Problems:
- q938_range_sum_of_BST
- q700_search_in_a_BST


# Prefix Tree / Trie
Trie is a useful data structure for matching strings with prefixes. Comparing to a hashtable, trie does not need to compute the hash function and avoids collision overhead. A trie is a tree of TrieNodes, each of which contains a string representing the word, and a list of children TrieNodes. The length of `children` is the size of the alphabet (usually 26). We can insert/search words into a trie using standard DFS. The following snippet shows an implementation:
```java
class TrieNode {
  TrieNode[] children;
  String val;

  public TrieNode() {
    val = null;
    children = new TrieNode[26];
  }
}

class Trie {
  TrieNode root;

  public Trie(String[] words) {
    root = new TrieNode();
    for (String word : words) insert(word);
  }

  public void insert(String word) {
    TrieNode curr = root;
    for (int i = 0; i < word.length(); i++) {
      int index = word.charAt(i) - 'a';
      if (curr.children[index] == null) {
        curr.children[index] = new TrieNode();
      }
      curr = curr.children[index];
    }
    curr.val = word;
  }
}
```
Related Problems:
- q208_implement_trie
- q212_word_search_ii
- q421_maximum_xor_of_two_numbers_in_an_array
- q648_replace_words
- q676_implement_magic_dictionary
- q677_max_sum_pairs
- q720_longest_word_in_dictionary


# Segment Tree
Segment tree is useful for *range queries* e.g. how many elements are in a range, what is the maximum/minimum/sum of elements in the range. In high-level terms, a segment tree node stores the following info:

1. what is the associated range of the node
2. what is the aggregate value of that range
3. what are the children range of the node (i.e., if a node has range [a, b], the left child should have range [a, mid] and the right child [mid, b] s.t. two children together covers the parent range.)

Internally, we can use an 1-d array to represent the tree and exploit the parent-children index relation:

> For a binary tree, if parent is stored at index i, then the left child is stored at 2*i and the right child 2*i + 1.

The following code snippet shows the implementation of a segment tree for range-sum queries. (i.e., sum of all elements in a range). The implementation contains three major functions:

1. Segment Tree constructor: In this function, we copy elements from the input array into the tree array, and iteratively calculate their parents. Note two things: 1) elements in the input array are leaf nodes, so they are stored to the right half of the `tree` array. 2) we do not need to explicitly store the ranges because they are already available by the index relation. We only need to store the aggregate value in the `tree` array.

2. Update an element at an index: In this function, we update the node as well as its parents. Note that we use the index relation again to identify if the node is a left child or a right child of its parent.

3. Query a range: This is the most tricky one. We need to keep two pointers indicating the current range, and iteratively move them up and update the result until the two pointers meet. 

```java
class SegmentTree {
  int[] tree;   // tree[i] stores the sum of elements in a range
  int n;        // total number of leaf nodes in the tree

  public SegmentTree(int[] nums) {
    n = nums.length;
    tree = new int[n * 2]; // need 2*n space to store all leaf nodes and their parents

    // construct the segment tree
    // 1). copy all values from num into tree[n, 2n]. They are leaf values.
    for (int i = n, j = 0; j < n; i++, j++) {
      tree[i] = nums[j];
    }

    // 2). iteratively compute non-leaf values using parent-children index relation
    for (int i = n - 1; i > 0; i--) {
      tree[i] = tree[i * 2] + tree[i * 2 + 1];
    }
  }

  public void update(int pos, int val) {
    // 1). convert pos to tree index and update leaf value
    pos += n;
    tree[pos] = val;
    // 2). iteratively update parents
    while (pos > 0) {
      int left  = pos % 2 == 0 ? pos : pos - 1;
      int right = pos % 2 == 0 ? pos + 1 : pos;
      tree[pos / 2] = tree[left] + tree[right];
      pos /= 2;
    }
  }

  public int sumRange(int left, int right) {
    // 1). get leaves corresponding to left and right
    left += n; right += n;
    int sum = 0;
    while (left <= right) {
      // 2). extra left, should not be included in the sum.
      if (left % 2 == 1) {
        // add the value to sum, and increment left
        sum += tree[left];
        left++;
      }
      if (right % 2 == 0) {
        sum += tree[right];
        right--;
      }
      // 3). go to their parents
      left /= 2;
      right /= 2;
    }
    return sum;
  }
}
```

Related Problems:
- q207_range_sum_query-mutable

# Graph
Graphs are usually represented using adjacency list, where each node stores its neighbors in a list:
```java
Map<Integer, List<Integer>> graph;
```
If the number of nodes in a graph is small, we can also use adjacency matrix, where `graph[i][j]` represents the edge `i->j`.
```java
int[][] graph;
```

## DFS/BFS
DFS of a graph can either be done recursively or using a stack.
```java
Stack<Integer> s = new Stack<>();
s.push(0);
seen[0] = true;
while (!st.isEmpty()) {
  int node = s.pop();
  for (int neighbor : graph[node]) {
    if (seen[neighbor]) continue;
    s.push(neighbor);
    seen[neighbor] = true;
  }
}
```
Related Problems:
- q785_is_graph_bipartite
- q323_number_of_connected_components_in_an_undirected_graph
- q399_evaluate_division

## Dijkstra's Algorithm
Dijkstra's algorithm is a greedy algorithm used to find shortest path in a directed, weighted graph.

## Topological Sort
Topological sort traverses graph nodes based on their in-degree (how many edges pointing to the node). Graphs with cycles do not have a topological order as nodes in a cycle has the same in-degree (1). Given a graph G and in-degree map I, we can use a queue to perform topological sort (Kahn's algorithm):
```java
Queue<Integer> q = new LinkedList<>();
for (int n : I) {
  if (I[n] == 0) q.add(n);
}
int idx = 0;
while (!q.isEmpty()) {
  int node = q.remove();
  idx++;
  for (int neighbor : G.get(node)) {
    I[neighbor]--;
    if (I[neighbor] == 0) q.add(neighbor);
  }
}
// if idx < total number of nodes, then there are cycles!
```
Related Problems:
- q210_course_schedule_ii


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

## Eulerian Path & Cycle
An Eulerian path visits all edges in a graph exactly once (allowing for revisiting vertices). An Eulerian cycle is an Eulerian path that starts and ends with the same node. Hierzolher's algorithm finds the Eulerian cycle in O(E) time. The high-level intuition is the following:

1. Randomly choose a start node and constructs a cycle. If this cycle covers all nodes, then it is the Eulerian cycle.
2. If not, for each node that contains edges not in the cycle, construct another cycle (called subtour). The Eulerian cycle can be build by integrating all detours into the first cycle.

Hierzolher's algorithm can be adapted to find the Eulerian path by not initially constructing a cycle, but instead constructing a path that does not end with any unvisited edges.

# Disjoint Set / Union Find
Given a collection of elements and a relation between then with transitivity, we can query if any two elements have the relation.

```Java
class UnionFind {
  int count; // number of disjoint sets
  int[] parent;
  int[] rank;

  public UnionFind(int n) {
    count = n;
    parent = new int[n];
    rank = new int[n];
    for (int i = 0; i < n; i++) parent[i] = i;
  }

  public int find(int p) {
    while (p != parent[p]) {
      parent[p] = parent[parent[p]];
      p = parent[p];
    }
    return p;
  }

  public void union(int p, int q) {
    int rp = find(p);
    int rq = find(q);
    if (rp == rq) return;
    if (rank[rq] > rank[rp]) {
      parent[rp] = rq;
    } else if (rank[rq] < rank[rp] {
      parent[rq] = rp;
    } else {
      // if both ranks are the same, doesn't matter which one
      // goes under which one.
      parent[rq] = rp;
      rank[rp]++;
    }
    count--;
  }
}
```

Related Problems:
- q218_longest_consecutive_sequence
- q547_number_of_provinces
q1258_synonymous_sentences


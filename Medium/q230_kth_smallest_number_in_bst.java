// [BST, traversal]

/** Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
  * Example 1:
  * Input: root = [3,1,4,null,2], k = 1
       3
      / \
     1   4
      \
       2
  * Output: 1
  *
  * Example 2:
  * Input: root = [5,3,6,2,4,null,null,1], k = 3
           5
          / \
         3   6
        / \
       2   4
      /
     1
  * Output: 3
  */
  class Solution {
      // first find the inorder traversal of the BST, store that in an array.
      // then return the kth element in that array.
      public int kthSmallest(TreeNode root, int k) {
          List<Integer> arr = new ArrayList<>();
          inorder(root, arr);
          return arr.get(k-1);
      }

      private void inorder(TreeNode root, List<Integer> arr) {
          if (root == null) return;
          inorder(root.left, arr);
          arr.add(root.val);
          inorder(root.right, arr);
      }
}

class Solution {
    // inorder traversal using stack
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !s.isEmpty()) {
            while (curr != null) {
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            k--;
            if (k == 0) {
                return curr.val;
            }
            curr = curr.right;
        }

        // should never happen
        return -1;
    }
}

class Solution {
    Map<TreeNode, Integer> leftCount;

    public int kthSmallest(TreeNode root, int k) {
        leftCount = new HashMap<>();
        count(root);
        return find(root, k);
    }

    private int find(TreeNode root, int k) {
        int lc = leftCount.getOrDefault(root, 0);
        if (lc + 1 == k) {
            return root.val;
        } else if (lc + 1 > k) {
            return find(root.left, k);
        } else {
            return find(root.right, k-1-lc);
        }
    }

    private int count(TreeNode root) {
        if (root == null) return 0;

        int l = count(root.left);
        int r = count(root.right);

        leftCount.put(root, l);

        return 1 + l + r;
    }
}

class Solution {
    int count;
    int res;

    // like the 1st solution, but there is no need to store inorder search results in 
    // an array. A single int is sufficient.
    
    public int kthSmallest(TreeNode root, int k) {
        count = k-1;
        res = -1;
        inorder(root);
        return res;
    }
    
    private void inorder(TreeNode root) {
        if (root == null || res > -1) return;
        inorder(root.left);
        if (count == 0) {
            res = root.val;
        }
        count--;
        inorder(root.right);
    }
}

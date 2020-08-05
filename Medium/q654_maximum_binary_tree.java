
/** Given an integer array with no duplicates. A maximum tree building on this array is
  * defined as follow:
  *     The root is the maximum number in the array.
  *     The left subtree is the maximum tree constructed from left part subarray
        divided by the maximum number.
  *     The right subtree is the maximum tree constructed from right part subarray
        divided by the maximum number.
  * Construct the maximum tree by the given array and output the root node of this tree.
  *
  * Example 1:
  * Input: [3,2,1,6,0,5]
  * Output: return the tree root node representing the following tree:

            6
          /   \
         3     5
          \    /
           2  0
             \
              1
   *
   */

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length-1);
    }

    private TreeNode buildTree(int[] nums, int from, int to) {
        if (to < from) {
            return null;
        }
        int max = nums[from];
        int maxi = from;
        for (int i = from+1; i <= to; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxi = i;
            }
        }
        TreeNode curr = new TreeNode(nums[maxi]);
        curr.left = buildTree(nums, from, maxi-1);
        curr.right = buildTree(nums, maxi+1, to);
        return curr;
    }
}


/** Given an array where elements are sorted in ascending order, convert it to a
  * height balanced BST.
  * For this problem, a height-balanced binary tree is defined as a binary tree
  * in which the depth of the two subtrees of every node never differ by more than 1.
  * Example:
  * Given the sorted array: [-10,-3,0,5,9],
  * One possible answer is: [0,-3,9,-10,null,5].
  */

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(nums, 0, nums.length-1);
    }

    private TreeNode makeTree(int[] nums, int from, int to) {
        if (from > to) return null;
        if (from == to) return new TreeNode(nums[from]);

        int mid = (from + to) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = makeTree(nums, from, mid-1);
        root.right = makeTree(nums, mid+1, to);
        return root;
    }
}

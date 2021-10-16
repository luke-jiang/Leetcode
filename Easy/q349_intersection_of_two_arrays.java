// [Sorting]

/** Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be 
  * unique and you may return the result in any order.
  *
  * Example 1:
  * Input: nums1 = [1,2,2,1], nums2 = [2,2]
  * Output: [2]
  */

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                int val = nums1[i];
                if (res.size() == 0 || res.get(res.size() - 1) != val) {
                    res.add(val);
                }
                i++; j++;
            }
        }
        int[] ans = new int[res.size()];
        for (i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}

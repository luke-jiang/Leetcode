// [Boyer-Moore]

/** Given an integer array of size n, find all elements that appear more than
  * ⌊n/3⌋ times.
  * Note: The algorithm should run in linear time and in O(1) space.
  * Examples:
  * [3,2,3] -> [3]
  * [1,1,1,3,3,2,2,2] -> [1,2]
  */

class Solution {
    // a modification of Boyer-Moore's majority vote algorothm.
    public List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0;
        int pre1 = -1;
        int cnt2 = 0;
        int pre2 = -1;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (pre1 == x) {
                cnt1++;
            } else if (pre2 == x) {
                cnt2++;
            } else if (cnt1 == 0) {
                pre1 = x;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                pre2 = x;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // verification pass
        cnt1 = 0;
        cnt2 = 0;
        for (int i : nums) {
            if (i == pre1) cnt1++;
            if (i == pre2) cnt2++;
        }
        List<Integer> res = new ArrayList<>();
        if (cnt1 > nums.length / 3) res.add(pre1);
        if (cnt2 > nums.length / 3) res.add(pre2);

        return res;
    }
}

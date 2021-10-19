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
        int cnt2 = 0;
        Integer pre1 = null;
        Integer pre2 = null;

        for (int n : nums) {
            if (pre1 != null && pre1 == n) {
                cnt1++;
            } else if (pre2 != null && pre2 == n) {
                cnt2++;
            } else if (cnt1 == 0) {
                pre1 = n;
                cnt1 = 1;
            } else if (cnt2 == 0) {
                pre2 = n;
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        // verification pass
        cnt1 = 0;
        cnt2 = 0;
        for (int n : nums) {
            if (pre1 != null && n == pre1) cnt1++;
            if (pre2 != null && n == pre2) cnt2++;
        }
        List<Integer> res = new ArrayList<>();
        if (cnt1 > nums.length / 3) res.add(pre1);
        if (cnt2 > nums.length / 3) res.add(pre2);

        return res;
    }
}

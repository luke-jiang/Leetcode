class Solution {
    public int search(int[] nums, int target) {
        
        int from = 0;
        int to = nums.length;
        if (from == to) return -1;
        
        while (from < to - 1) {
            int mid = (from + to) / 2;
            int midval = nums[mid];
            
            if (midval == target) return mid;
            if (nums[from] == target) return from;
            if (nums[to-1] == target) return to-1;
            
            if (midval < nums[to-1] && midval < nums[from]) { // mid < t < f
                if (target < midval) to = mid;
                else if (target < nums[to-1]) from = mid;
                else if (target < nums[from]) return -1;
                else to = mid;
            } else if (midval > nums[from] && midval> nums[to-1]) {  // t < f < mid
                if (target < nums[to-1]) from = mid;
                else if (target < nums[from]) return -1;
                else if (target < midval) to = mid;
                else from = mid;

            } else {
                if (target < midval) to = mid;
                else from = mid;
            }
        }
        
        return nums[from] == target ? from : -1;
    }
}

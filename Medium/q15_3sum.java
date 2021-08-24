// [Two-Pointers, Pre-Sort]

class Solution1 {
    List<List<Integer>> res;

    // two-pointer 2 sum (in a sorted array)
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        res = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            // only need to traverse numbers that are smaller than zero
            if (i == 0 || nums[i-1] != nums[i]) {
                // skip identical numbers
                twoSum(nums, i);
            }
        }
        return res;
    }

    private void twoSum(int[] nums, int i) {
        int low = i + 1;
        int high = nums.length - 1;
        while (low < high) {
            int sum = nums[i] + nums[low] + nums[high];
            if (sum < 0) {
                low++;
            } else if (sum > 0) {
                high--;
            } else {
                List<Integer> cand = new ArrayList<>();
                cand.add(nums[i]);
                cand.add(nums[low]);
                cand.add(nums[high]);
                res.add(cand);
                low++;
                high--;
                // avoid adding duplicates
                while (low < high && nums[low] == nums[low-1]) {
                    low++;
                }
            }
        }
    }
}

class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i-1] != nums[i]) {
                twoSum(nums, i, res);
            }
        }
        return res;
    }

    // HashMap
    private void twoSum(int[] nums, int i, List<List<Integer>> res) {
        Set<Integer> seen = new HashSet<>();
        for (int j = i + 1; j < nums.length; j++) {
            int complement = -nums[i] - nums[j];
            if (seen.contains(complement)) {
                res.add(Arrays.asList(nums[i], nums[j], complement));
                while (j + 1 < nums.length && nums[j] == nums[j+1]) {
                    j++;
                }
            }
            seen.add(nums[j]);
        }
    }
}

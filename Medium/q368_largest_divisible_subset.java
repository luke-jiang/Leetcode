// [DP, Modulo, pre-sort]

// KEY OBSERVATIONS:
// Given a list of values [E,F,G] sorted in ascending order (E<F<G), and the list
// itself forms a divisible subset as described in the problem, then we could extend
// the subset without enumerating all numbers in the subset.
// Corollary I: if h % G == 0, then [E,F,G,h] is also a divisible subset.
// Corollary II: if E % d == 0, then [d,E,F,G] is also a divisible subset.

// For an order list [X1, X2, X3...], the largest divisible subset from this
// list is the largest subset among all possible divisible subsets that end with
// each of the number in the list.

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList();

        // subsets stores all divisible subsets that ends with nums[i] forall i.
        List<ArrayList> subsets = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            subsets.add(new ArrayList<>());
        }

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            List<Integer> maxsubset = new ArrayList<>();

            // find the lsrgest divisible subset of previous elements
            for (int k = 0; k < i; k++) {
                if (nums[i] % nums[k] == 0 && maxsubset.size() < subsets.get(k).size()) {
                    maxsubset = subsets.get(k);
                }
            }

            subsets.get(i).addAll(maxsubset);
            subsets.get(i).add(nums[i]);
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (res.size() < subsets.get(i).size()) {
                res = subsets.get(i);
            }
        }

        return res;
    }
}

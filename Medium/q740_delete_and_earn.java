// [DP] **


/** Rationale:
  * 1. The order of input array does not matter. What matters is the frequencies of each element.
  *    Since nums[i] <= 10000, we can calculate a `freq` table of size 10000.
  * 2. To construct the maximum result, each number in `freq` is either selected or not selected,
  *    under the constraint that adjacent two numbers cannot both be selected.
  * 3. Given a new number X, it is always possible to construct the answer for X by considering 
  *    answer for the previous number, which is either:
  *    - prev == X-1: we must use the answer that doesn't include the score for prev
  *    - prev != X-1: we can use the answer that includes the score for prev
  */

class Solution {
    public int deleteAndEarn(int[] nums) {
        int len = 10000;
        int[] freq = new int[len+1];
        for (int n : nums) freq[n]++;

        int using = 0;
        int avoid = 0;
        int prev = -1;

        for (int i = 0; i < len+1; i++) {
            if (freq[i] == 0) continue;
            int max = Math.max(using, avoid);
            if (i != prev + 1) {
                using = i * freq[i] + max;
                avoid = max;
            } else {
                using = i * freq[i] + avoid;
                avoid = max;
            }
            prev = i;
        }

        return Math.max(using, avoid);
    }
}

class Solution {
    // use(i) = avoid(i-1) + freq(i) * i
    // avoid(i) = max { use(i-1), avoid(i-1) }
    public int deleteAndEarn(int[] nums) {
        int len = 10001;
        int[] freq = new int[len];
        for (int n : nums) freq[n]++;
        
        int use = 0;
        int avoid = 0;
        for (int i = 0; i < len; i++) {
            int use1 = avoid + freq[i] * i;
            int avoid1 = Math.max(use, avoid);
            use = use1;
            avoid = avoid1;
        }
        return Math.max(use, avoid);
    }
}

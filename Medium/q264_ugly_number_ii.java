// [DP]

/** Write a program to find the n-th ugly number.
  * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
  * Example:
  * Input: n = 10
  * Output: 12
  * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
  * Note:
  * - 1 is typically treated as an ugly number.
  * - n does not exceed 1690.
*/

class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1);
        int prev = 0;
        for (int i = 0; i < n; i++) {
            int x = pq.poll();
            if (x == prev) {
                i--;
                continue;
            }
            prev = x;
            if (x < Integer.MAX_VALUE / 2) {
                pq.add(x * 2);
            }
            if (x < Integer.MAX_VALUE / 3) {
                pq.add(x * 3);
            }
            if (x < Integer.MAX_VALUE / 5) {
                pq.add(x * 5);
            }
        }
        return prev;
    }
}

class Solution {
    public int nthUglyNumber(int n) {
        if (n == 1) return 1;
        int[] nums = new int[n];
        int[] factor = new int[n];
        Arrays.fill(factor, 2);

        nums[0] = 1;

        int from = 0;
        int to = 0;
        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = from; j <= to; j++) {
                if (nums[j] > Integer.MAX_VALUE / factor[j]) continue;
                int cand = nums[j] * factor[j];
                if (cand < min) {
                    min = cand;
                    candidates.clear();
                    candidates.add(j);
                } else if (cand == min) {
                    candidates.add(j);
                }
            }
            nums[i] = min;
            for (int d : candidates) {
                if (factor[d] == 2) factor[d] = 3;
                else if (factor[d] == 3) factor[d] = 5;
                else if (factor[d] == 5) factor[d] = -1;
            }
            while (factor[from] == -1) from++;
            while (factor[to] != 2) to++;
            candidates.clear();
        }
        /*
        for (int x : nums) {
            System.out.println(x);
        }*/
        return nums[n-1];
    }
}

class Solution {
    // cache the indices of three candidates (*2, *3, *5)
    // prev2 is the pointer to the number whose value * 2 has not yet been considered.
    // similar fot prev3 and prev5
    public int nthUglyNumber(int n) {
        if (n < 7) return n;
        int[] nums = new int[n];

        for (int i = 0; i < 6; i++) {
            nums[i] = i+1;
        }

        int prev2 = 3;
        int prev3 = 2;
        int prev5 = 1;

        for (int i = 6; i < n; i++) {
            // choose the smaller one out of three possibilities
            nums[i] = Math.min(2*nums[prev2], Math.min(3*nums[prev3], 5*nums[prev5]));
            // increment the pointer by 1, because if x * nums[i] is currently chosen,
            // then x * nums[i+1] is definitely not yet considered, and there is no smaller
            // index i' s.t. x * nums[i'] is not yet considered. Therefore, i+1 is the next
            // index to consider.
            if (nums[i] == 2*nums[prev2]) prev2++;
            if (nums[i] == 3*nums[prev3]) prev3++;
            if (nums[i] == 5*nums[prev5]) prev5++;
        }

        return nums[n-1];
    }
}

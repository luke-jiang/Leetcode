// [BinarySearch]

/** Given an integer array bloomDay, an integer m and an integer k.
  * We need to make m bouquets. To make a bouquet, you need to use k adjacent flowers
  * from the garden.
  * The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and
  * then can be used in exactly one bouquet.
  * Return the minimum number of days you need to wait to be able to make m bouquets
  * from the garden. If it is impossible to make m bouquets return -1.
  *
  * Example 1:
  * Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
  * Output: 3
  * Explanation: Let's see what happened in the first three days. x means flower bloomed
  * and _ means flower didn't bloom in the garden.
  * We need 3 bouquets each should contain 1 flower.
  * After day 1: [x, _, _, _, _]   // we can only make one bouquet.
  * After day 2: [x, _, _, _, x]   // we can only make two bouquets.
  * After day 3: [x, _, x, _, x]   // we can make 3 bouquets. The answer is 3.
  *
  * Example 2:
  * Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
  * Output: -1
  * Explanation: We need 3 bouquets each has 2 flowers, that means we need 6 flowers.
  * We only have 5 flowers so it is impossible to get the needed bouquets and we return -1.
  *
  * Example 3:
  * Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
  * Output: 12
  * Explanation: We need 2 bouquets each should have 3 flowers.
  * Here's the garden after the 7 and 12 days:
  * After day 7: [x, x, x, x, _, x, x]
  * We can make one bouquet of the first three flowers that bloomed. We cannot make another
  * bouquet from the last three flowers that bloomed because they are not adjacent.
  * After day 12: [x, x, x, x, x, x, x]
  * It is obvious that we can make two bouquets in different ways.
  *
  */

class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int numFlowers = bloomDay.length;
        if (m * k > numFlowers) {
            return -1;
        }
        int low = 0;
        int high = bloomDay[0];
        for (int d : bloomDay) {
            high = Math.max(high, d);
        }
        int max = high;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (!valid(bloomDay, m, k, mid, max)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private boolean valid(int[] bloomDay, int m, int k, int mid, int max) {
        int flowers = 0;      // current available flowers that are not yet made into bouquets
        int bouquets = 0;     // current number of bouquets made
        for (int bd : bloomDay) {
            if (bd <= mid) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                // encountered a flower that blooms much later,
                // consequtiveness violated
                flowers = 0;
            }
        }
        return bouquets >= m;
    }
}

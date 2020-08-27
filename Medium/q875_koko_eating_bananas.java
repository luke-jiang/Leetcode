// [BinarySearch] ***

/** Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has
  * piles[i] bananas.  The guards have gone and will come back in H hours.
  * Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses
  * some pile of bananas, and eats K bananas from that pile.  If the pile has less
  * than K bananas, she eats all of them instead, and won't eat any more bananas
  * during this hour.
  * Koko likes to eat slowly, but still wants to finish eating all the bananas
  * before the guards come back.
  * Return the minimum integer K such that she can eat all the bananas within H hours.
  *
  * Example 1:
  * Input: piles = [3,6,7,11], H = 8
  * Output: 4
  */

class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int low = 1;
        int high = 1000000000;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (!valid(piles, H, mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private boolean valid(int[] piles, int H, int K) {
        int hours = 0;
        for (int p : piles) {
            hours += Math.ceil((double) p / K);
        }
        return hours <= H;
    }
}

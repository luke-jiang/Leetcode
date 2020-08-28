
/** There are two sorted arrays nums1 and nums2 of size m and n respectively.
  * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
  * You may assume nums1 and nums2 cannot be both empty.
  *
  * Examples:
  * ([1, 3], [2]) -> 2.0
  * ([1, 2], [3, 4]) -> 2.5
  */

// INTUITION:
// firstly, the problem is converted to find the kth element in the merged
// array of two sorted arrays A and B.
// Then, consider subarray A[0, k/2] and B[0, k/2], the desired element is the
// maximum of these two subarrays. So, we can compare A[k/2] and B[k/2] and see
// which one is smaller. If A[k/2] is smaller, then elements in A[0, k/2] < B[k/2]
// <= desired element, so we know they are definitely not the answer.

class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
	    int m = A.length, n = B.length;
	    int l = (m + n + 1) / 2;
	    int r = (m + n + 2) / 2;
	    return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
	}

    // get the k-th element in the merged array of A[aStart:end] and B[bStart:end]
    public double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) return B[bStart + k - 1];
        if (bStart > B.length - 1) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1];
        if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];

        if (aMid < bMid)
            return getkth(A, aStart + k/2, B, bStart,       k - k/2);// Check: aRight + bLeft
        else
            return getkth(A, aStart,       B, bStart + k/2, k - k/2);// Check: bRight + aLeft
    }
}

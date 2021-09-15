// [Monotonic Stack]
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len = nums2.length;
        int[] nextGreater = new int[len];
        Arrays.fill(nextGreater, -1);
        
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums2[stack.peek()] < nums2[i]) {
                nextGreater[stack.pop()] = nums2[i];
            }
            stack.push(i);
            map.put(nums2[i], i);
        }
        
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int tmp = map.get(nums1[i]);
            res[i] = nextGreater[map.get(nums1[i])];
        }
        
        return res;
    }
}

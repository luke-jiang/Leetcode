// [Stack]

/** Given two sequences pushed and popped with distinct values, return true if and only if
  * this could have been the result of a sequence of push and pop operations on an initially
  * empty stack.
  *
  * Example 1:
  * Input:        pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
  * Output:       true
  * Explanation: We might do the following sequence:
      push(1), push(2), push(3), push(4), pop() -> 4,
      push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
  *
  * Example 2:
  * Input:        pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
  * Output:       false
  * Explanation: 1 cannot be popped before 2.
  *
  * Note:
  *
  * 0 <= pushed.length == popped.length <= 1000
  * 0 <= pushed[i], popped[i] < 1000
  * pushed is a permutation of popped.
  * pushed and popped have distinct values.
  */

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0;
        int j = 0;
        Stack<Integer> s = new Stack<>();
        while (i < pushed.length && j < popped.length) {
            if (s.size() > 0 && s.peek() == popped[j]) {
                s.pop();
                j++;
            } else {
                s.push(pushed[i]);
                i++;
            }
        }

        while (j < popped.length && s.size() > 0 && s.peek() == popped[j]) {
            s.pop();
            j++;
        }

        return s.size() == 0;
    }
}

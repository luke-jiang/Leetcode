// [BFS]

/** Given a string s that contains parentheses and letters, remove the minimum number of invalid parentheses to make the input string valid.
  * Return all the possible results. You may return the answer in any order.
  * Example 1:
  * Input: s = "()())()"
  * Output: ["(())()","()()()"]
  */

class Solution {
    private boolean isValid(String s) {
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftCount++;
            } else if (c == ')') {
                leftCount--;
                if (leftCount < 0) return false;
            }
        }
        return leftCount == 0;
    }
    
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        seen.add(s);
        boolean found = false;
        while (!q.isEmpty() && !found) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.remove();
                if (isValid(curr)) {
                    res.add(curr);
                    found = true;
                }
                for (int j = 0; j < curr.length() && !found; j++) {
                    if (curr.charAt(j) != '(' && curr.charAt(j) != ')') continue;
                    String next = curr.substring(0, j) + curr.substring(j+1);
                    if (!seen.contains(next)) {
                        q.add(next);
                        seen.add(next);
                    }
                }
            }
        } 
        return res;
    }
}

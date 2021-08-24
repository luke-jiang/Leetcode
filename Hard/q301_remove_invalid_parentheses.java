class Solution {

    private boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                count++;
            }
            if (c == ')' && count-- == 0) {
                return false;
            }
        }
        return count == 0;
    }


    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();

        if (s == null) {
            return res;
        }

        Queue<String> q = new LinkedList<>();
        Set<String> seen = new HashSet<>();

        q.add(s);
        seen.add(s);

        boolean found = false;
        while (!q.isEmpty() && !found) {

            int size = q.size();
            for (int j = 0; j < size; j++) {
                s = q.poll();
                if (isValid(s)) {
                    res.add(s);
                    found = true;
                }

                for (int i = 0; i < s.length() && !found; i++) {
                    if (s.charAt(i) != '(' && s.charAt(i) != ')') {
                        continue;
                    }
                    String t = s.substring(0, i) + s.substring(i+1);
                    if (!seen.contains(t)) {
                        q.add(t);
                        seen.add(t);
                    }
                }
            }
        }

        return res;
    }
}

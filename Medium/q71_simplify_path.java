class Solution {
    public String simplifyPath(String path) {
        Deque<String> st = new LinkedList<>();
        String[] ops = path.substring(1).split("/+");
        // System.out.println(Arrays.toString(ops));
        for (String op : ops) {
            if (op.equals(".") || op.length() == 0) {
                continue;
            } else if (op.equals("..")) {
                if (!st.isEmpty()) st.pollLast();
            } else {
                st.offerLast(op);
            }
        }
        if (st.isEmpty()) return "/";
        
        List<String> list = new ArrayList(st);
        return "/" + String.join("/", list);
    }
}

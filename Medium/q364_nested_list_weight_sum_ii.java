class Solution {
    Map<Integer, Integer> map;
    int maxDepth;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        map = new HashMap<>();
        maxDepth = 1;
        dfs(nestedList, 1);
        int res = 0;
        for (int d : map.keySet()) {
            int sum = map.get(d);
            res += (maxDepth - d + 1) * sum;
        }
        return res;
    }
    
    private void dfs(List<NestedInteger> root, int depth) {
        maxDepth = Math.max(maxDepth, depth);
        int sum = 0;
        for (NestedInteger i : root) {
            if (i.isInteger()) {
                sum += i.getInteger();
            } else {
                dfs(i.getList(), depth + 1);
            }
        }
        map.put(depth, map.getOrDefault(depth, 0) + sum);
    }
}

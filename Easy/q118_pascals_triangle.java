class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> init = new ArrayList<>();
        init.add(1);
        res.add(init);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prev = res.get(res.size() - 1);
            row.add(1);
            for (int j = 0; j < prev.size() - 1; j++) {
                row.add(prev.get(j) + prev.get(j+1));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }
}

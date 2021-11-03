class Solution {
    public int[][] highFive(int[][] items) {
        Arrays.sort(items, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        // System.out.println(Arrays.deepToString(items));
        List<int[]> res = new ArrayList<>();
        int counter = 4;
        for (int[] item : items) {
            if (res.isEmpty() || res.get(res.size()-1)[0] != item[0]) {
                res.add(item);
                counter = 4;
            } else if (counter > 0) {
                res.get(res.size()-1)[1] += item[1];
                counter--;
            }
        }
        int[][] ans = new int[res.size()][2];
        int i = 0;
        for (int[] item : res) {
            item[1] /= 5;
            ans[i] = item; i++;
        }
        return ans;
    }
}

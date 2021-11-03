class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int mindiff = Integer.MAX_VALUE;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int diff = arr[i+1] - arr[i];
            if (diff > mindiff) continue;
            List<Integer> ls = new ArrayList<>();
            ls.add(arr[i]);
            ls.add(arr[i+1]);
            if (diff < mindiff) {
                res.clear();
                mindiff = diff;
            }
            res.add(ls);
        }
        return res;
    }
}

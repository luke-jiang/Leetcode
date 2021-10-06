class Solution {
    List<int[]> arr = new ArrayList<>();
    
    public int[][] insert(int[][] intervals, int[] newInterval) {
        for (int[] i : intervals) arr.add(i);
        int idx = 0;
        while (idx < intervals.length && intervals[idx][0] < newInterval[0]) idx++;
        
        arr.add(idx, newInterval);
        
        while (idx >= 1) {
            if (!overlap(idx-1, idx)) break;
            idx = mergeBefore(idx);
        }
        while (idx <= arr.size() - 2) {
            if (!overlap(idx+1, idx)) break;
            idx = mergeAfter(idx);
        }
        
        int[][] ans = new int[arr.size()][2];
        for (int i = 0; i < arr.size(); i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }
    
    private boolean overlap(int i, int j) {
        int[] a = arr.get(i);
        int[] b = arr.get(j);
        return !(a[1] < b[0] || b[1] < a[0]);
    }
    
    private int mergeBefore(int i) {
        int[] prev = arr.get(i-1);
        int[] curr = arr.get(i);
        prev[0] = Math.min(prev[0], curr[0]);
        prev[1] = Math.max(prev[1], curr[1]);
        arr.remove(i);
        return i-1;
    }
    
    private int mergeAfter(int i) {
        int[] next = arr.get(i+1);
        int[] curr = arr.get(i);
        curr[0] = Math.min(next[0], curr[0]);
        curr[1] = Math.max(next[1], curr[1]);
        arr.remove(i+1);
        return i;
    }
}

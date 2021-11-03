class SnapshotArray {
    Map<Integer, Integer>[] arr;
    int T;
    public SnapshotArray(int length) {
        arr = new Map[length];
        T = 0;
        for (int i = 0; i < length; i++) {
            arr[i] = new HashMap<>();
            arr[i].put(0, 0);
        }
    }
    
    public void set(int index, int val) {
        Map<Integer, Integer> map = arr[index];
        map.put(T, val);
    }
    
    public int snap() {
        T++;
        return T - 1;
    }
    
    public int get(int index, int snap_id) {
        Map<Integer, Integer> map = arr[index];
        while (!map.containsKey(snap_id)) snap_id -= 1;
        return map.get(snap_id);
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */
 
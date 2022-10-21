class SparseVector {
    Map<Integer, Integer> map;
    
    SparseVector(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) map.put(i, nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;
        for (int i : this.map.keySet()) {
            if (vec.map.keySet().contains(i)) {
                res += this.map.get(i) * vec.map.get(i);
            }
        }
        return res;
    }
}


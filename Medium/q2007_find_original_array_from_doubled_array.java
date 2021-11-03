class Solution {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 != 0) return new int[0];
        Arrays.sort(changed);
        // build frequency map
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : changed) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer> ls = new ArrayList<>();
        // handle zeroes separately
        for (int k = 0; k < map.getOrDefault(0, 0) / 2; k++) ls.add(0);
        map.put(0, 0);
        
        for (int n : changed) {
            if (map.get(n) == 0) continue;
            if (!map.containsKey(2*n)) return new int[0];
            map.put(2*n, map.get(2*n) - map.get(n));
            for (int k = 0; k < map.get(n); k++) ls.add(n);
            map.put(n, 0);
        }
        // System.out.println(map);
        // System.out.println(ls);
        for (int n : map.keySet()) {
            if (map.get(n) != 0) return new int[0];
        }
        int[] res = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            res[i] = ls.get(i);
        }
        return res;
    }
}

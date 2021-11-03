class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        Map<Integer, Double> map = new HashMap<>(); // car position |-> time remains to reach target
        for (int i = 0; i < len; i++) {
            int remain = target - position[i];
            map.put(position[i], remain * 1.0 / speed[i]);
        }
        // System.out.println(map);
        Arrays.sort(position);
        int res = 0;
        Double timeTakenByLastCar = 0.0;
        for (int i = len-1; i >= 0; i--) {
            if (timeTakenByLastCar < map.get(position[i])) {
                // if the following car takes more time than the preceding car to reach dest,
                // then these two cars will never meet, thus they belong to two fleets.
                timeTakenByLastCar = map.get(position[i]);
                res++;
            }
        }
        return res;
    }
}

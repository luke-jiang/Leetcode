class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> types = new HashSet<>();
        for (int n : candyType) {
            types.add(n);
        }
        return Math.min(candyType.length / 2, types.size());
    }
}

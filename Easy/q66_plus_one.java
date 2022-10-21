class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length-1]++;
        List<Integer> ls = new LinkedList<>();
        for (int n : digits) ls.add(n);
        int i = ls.size() - 1;
        while (i > 0 && ls.get(i) >= 10) {
            ls.set(i, ls.get(i) - 10);
            ls.set(i-1, ls.get(i-1) + 1);
            i--;
        }
        if (ls.get(0) >= 10) {
            ls.add(0, 1);
            ls.set(1, ls.get(1) - 10);
        }
        int[] res = new int[ls.size()];
        for (i = 0; i < ls.size(); i++) {
            res[i] = ls.get(i);
        }
        return res;
    }
}

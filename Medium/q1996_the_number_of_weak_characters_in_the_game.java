class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int len = properties.length;
        int res = 0;

        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return b[1] - a[1];
            }
        });

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && 
                   properties[stack.peek()][1] < properties[i][1]) {
                stack.pop();
                res++;
            }
            stack.push(i);
        }

        return res;
    }
}

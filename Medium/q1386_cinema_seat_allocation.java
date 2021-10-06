class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats, (i, j) -> i[0] - j[0]);
        int res = n * 2;
        int rightMask = 30;
        int midMask = 120;
        int leftMask = 480;
        int rowMask = 1023;
        
        int prevRow = reservedSeats[0][0];
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];
            if (row == prevRow) {
                rowMask = rowMask & (~(1 << (col - 1)));
            } else {
                boolean rightFit = (rowMask & rightMask) == rightMask;
                boolean middleFit = (rowMask & midMask) == midMask;
                boolean leftFit = (rowMask & leftMask) == leftMask;
                if (!rightFit) res--;
                if (!leftFit) res--;
                if (!rightFit && !leftFit && middleFit) res++;
                prevRow = row;
                rowMask = 1023 & (~(1 << (col - 1)));
            }
        }
        boolean rightFit = (rowMask & rightMask) == rightMask;
        boolean middleFit = (rowMask & midMask) == midMask;
        boolean leftFit = (rowMask & leftMask) == leftMask;
        if (!rightFit) res--;
        if (!leftFit) res--;
        if (!rightFit && !leftFit && middleFit) res++;
        return res;
    }
}

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dims = binaryMatrix.dimensions();
        int rows = dims.get(0);
        int cols = dims.get(1);
        
        int i = cols - 1;
        while (i >= 0 && binaryMatrix.get(0, i) == 1) i--;

        for (int j = 0; j < rows; j++) {
            while (i >= 0 && binaryMatrix.get(j, i) == 1) i--;
        }
        if (i == cols - 1) return -1;
        return i+1;
    }
}

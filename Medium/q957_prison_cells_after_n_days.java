class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        HashMap<Integer, Integer> seen = new HashMap<>(); // store seen patterns |-> days
        boolean hasLoop = false;
        while (n > 0) {
            if (!hasLoop) {
                int bit = cells2bitmap(cells);
                if (seen.containsKey(bit)) {
                    n %= seen.get(bit) - n;
                    hasLoop = true;
                } else {
                    seen.put(bit, n);
                }
            }
            if (n > 0) {
                n--;
                cells = nextDay(cells);
            }
        }
        return cells;
    }

    private int cells2bitmap(int[] cells) {
        int res = 0x0;
        for (int n : cells) {
            res <<= 1;
            res = res | n;
        }
        return res;
    }
    
    private int[] nextDay(int[] cells) {
        int len = cells.length;
        int[] newCells = new int[len];
        newCells[0] = 0;
        for (int j = 1; j < len - 1; j++) {
            newCells[j] = cells[j-1] == cells[j+1] ? 1 : 0;
        }
        newCells[len-1] = 0;
        return newCells;
    }
}

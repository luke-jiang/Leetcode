class Solution {
    public boolean isRobotBounded(String instructions) {
        int[][] directions = new int[][] {
            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
        };
        
        int x = 0;
        int y = 0;
        int idx = 0; // which direction the robot is currently facing
        
        for (char c : instructions.toCharArray()) {
            if (c == 'L') {
                idx = (idx + 3) % 4;
            } else if (c == 'R') {
                idx = (idx + 1) % 4;
            } else {
                x += directions[idx][0];
                y += directions[idx][1];
            }
        }
        
        return (x == 0 && y == 0) || (idx != 0);
    }
}

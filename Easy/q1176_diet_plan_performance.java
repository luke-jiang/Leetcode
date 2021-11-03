class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {      
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += calories[i];
        }

        int low = 0;
        int high = k - 1;
        int points = sum < lower ? -1 : sum > upper ? 1 : 0;

        while (high < calories.length - 1) {
            low++; high++;
            sum += calories[high];
            sum -= calories[low-1];
            points += sum < lower ? -1 : sum > upper ? 1 : 0;
        }
        return points;
    }
}

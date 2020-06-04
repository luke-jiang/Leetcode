// [Comparator]

/** Given a list of non negative integers, arrange them such that they form the largest number.
  * Examples:
  * [10,2] -> "210"
  * [3,30,34,5,9] -> "9534330"
  * Note: The result may be very large, so you need to return a string instead of an integer.
  */

class Solution {

    private class NumComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] numbers = new String[len];
        for (int i = 0; i < len; i++) {
            numbers[i] = "" + nums[i];
        }
        Arrays.sort(numbers, new NumComparator());

        if (numbers[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String str : numbers) {
            sb.append(str);
        }
        return sb.toString();
    }
}

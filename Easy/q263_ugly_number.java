class Solution {
    public boolean isUgly(int num) {

        if (num <= 0) return false;
        if (num == 1) return true;

        // num = Math.abs(num);
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        while (q.size() > 0) {
            int n = q.remove();
            if (n == 2 || n == 3 || n == 5) return true;
            if (n % 2 == 0) q.add(n/2);
            if (n % 3 == 0) q.add(n/3);
            if (n % 5 == 0) q.add(n/5);
        }
        return false;
    }
}

class Solution {
    public boolean isUgly(int num) {

        if (num <= 0) return false;
        if (num == 1) return true;

        // num = Math.abs(num);

        while (num % 2 == 0) num = num / 2;
        while (num % 3 == 0) num = num / 3;
        while (num % 5 == 0) num = num / 5;

        return num == 1;
    }

}

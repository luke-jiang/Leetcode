class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(id);
        int sum = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                Employee e = map.get(q.remove());
                sum += e.importance;
                for (int j : e.subordinates) {
                    q.add(j);
                }
            }
        }
        return sum;
    }
}

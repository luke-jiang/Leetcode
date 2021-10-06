class Solution {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digs = new ArrayList<>();
        List<String> lets = new ArrayList<>();
        for (String log : logs) {
            char last = log.charAt(log.length() - 1);
            if (last >= '0' && last <= '9') {
                lets.add(log);
            } else {
                digs.add(log);
            }
        }
        // System.out.println(digs);
        Collections.sort(digs, new Comparator<String>() {
            @Override
            public int compare(String x, String y) {
                String[] xs = x.split(" ", 2);
                String[] ys = y.split(" ", 2);
                int cmp = xs[1].compareTo(ys[1]);
                if (cmp != 0)   return cmp;
                else            return xs[0].compareTo(ys[0]);
            }
        });
        // System.out.println(digs);
        for (int i = 0; i < logs.length; i++) {
            if (i < digs.size()) {
                logs[i] = digs.get(i);
            } else {
                logs[i] = lets.get(i - digs.size());
            }
        }
        return logs;
    }
}

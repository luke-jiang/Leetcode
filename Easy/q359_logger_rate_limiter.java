class Logger {
    Map<String, Integer> map;

    public Logger() {
        map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message)) {
            map.put(message, timestamp + 10);
            return true;
        } else if (timestamp < map.get(message)) {
            return false;
        } else {
            map.put(message, timestamp + 10);
            return true;
        }
    }
}

// [HashMap]

/** Create a timebased key-value store class TimeMap, that supports two operations.
  *   1. set(string key, string value, int timestamp), which stores the key and value,
         along with the given timestamp.
  *   2. get(string key, int timestamp), which returns a value such that set(key, value,
          timestamp_prev) was called previously, with timestamp_prev <= timestamp.
          If there are multiple such values, it returns the one with the largest timestamp_prev.
          If there are no values, it returns the empty string ("").
  */

class TimeMap {
    // key -> (timestamp, value)
    Map<String, TreeMap<Integer, String>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new TreeMap<>());
        }
        map.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        TreeMap<Integer, String> tree = map.get(key);
        Integer t = tree.floorKey(timestamp);
        return t == null ? "" : tree.get(t);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

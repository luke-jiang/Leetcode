// [HashMap]

/** Design a data structure that supports all following operations in average O(1) time.
  * insert(val): Inserts an item val to the set if not already present.
  * remove(val): Removes an item val from the set if present.
  * getRandom: Returns a random element from current set of elements (it's guaranteed that
  *   at least one element exists when this method is called). Each element must have the
  *   same probability of being returned.
  */
  
class RandomizedSet {
    Map<Integer, Integer> map;
    List<Integer> ls;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        ls = new ArrayList();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {

        if (!map.containsKey(val)) {
            map.put(val, ls.size());
            ls.add(val);
            return true;
        }
        return false;

    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int last = ls.get(ls.size()-1);

        ls.set(index, last);
        map.put(last, index);
        ls.remove(ls.size()-1);
        map.remove(val);
        return true;

    }

    /** Get a random element from the set. */
    public int getRandom() {
        return ls.get(rand.nextInt(ls.size()));
    }
}

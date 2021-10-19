/** Design and implement a data structure for a Least Frequently Used (LFU) cache.
  *
  * Implement the LFUCache class:
    - LFUCache(int capacity) Initializes the object with the capacity of the data structure.
    - int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
    - void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. 
        When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting 
        a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least 
        recently used key would be invalidated.
  * To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest 
  * use counter is the least frequently used key.
  * When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key 
  * in the cache is incremented either a get or put operation is called on it.
  * The functions get and put must each run in O(1) average time complexity.
  *
  * Example 1:
  * Input
  * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
  * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
  * Output
  * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
  *
  * Explanation
    // cnt(x) = the use counter for key x
    // cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
    LFUCache lfu = new LFUCache(2);
    lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
    lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
    lfu.get(1);      // return 1
                     // cache=[1,2], cnt(2)=1, cnt(1)=2
    lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
                 // cache=[3,1], cnt(3)=1, cnt(1)=2
    lfu.get(2);      // return -1 (not found)
    lfu.get(3);      // return 3
                     // cache=[3,1], cnt(3)=2, cnt(1)=2
    lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
                     // cache=[4,3], cnt(4)=1, cnt(3)=2
    lfu.get(1);      // return -1 (not found)
    lfu.get(3);      // return 3
                     // cache=[3,4], cnt(4)=1, cnt(3)=3
    lfu.get(4);      // return 4
                     // cache=[3,4], cnt(4)=2, cnt(3)=3
 
  * Constraints:
    0 <= capacity <= 104
    0 <= key <= 105
    0 <= value <= 109
    At most 2 * 105 calls will be made to get and put.
  */

class LFUCache {
    // Use a linked list of doubly linked list
    // the base linked list stores all nodes of the same use counter
    // each doubly linked list stores (key, value) pairs from old to new
    class DataNode {
        int key;
        int val;
        DataNode prev;
        DataNode next;
        UseNode use;    // back pointer to the UseNode of this DataNode list
        public DataNode(int key, int val) {
            this.key = key; this.val = val; this.prev = null; this.next = null;
        }
    }
    
    class UseNode {
        int use;   // use counter
        int size;  // size of the DataNode list, excluding head and tail
        DataNode head;
        DataNode tail;
        UseNode next;
        public UseNode(int use, int size, UseNode next) {
            this.use = use;
            this.size = size;
            this.head = new DataNode(-1, -1);
            this.tail = new DataNode(-1, -1);
            head.next = tail;
            tail.prev = head;
        }
    }
    
    UseNode useHead;
    Map<Integer, DataNode> map;
    int cap;

    public LFUCache(int capacity) {
        useHead = new UseNode(1, 0, null);
        map = new HashMap<>();
        cap = capacity;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        DataNode n = map.get(key);
        increment(n);
        // print();
        return n.val;
    }
    
    public void put(int key, int value) {
        if (cap == 0) return;

        if (map.containsKey(key)) {
            DataNode n = map.get(key);
            n.val = value;
            increment(n);
        } else {
            if (map.keySet().size() == cap) {
                UseNode curr = useHead;
                while (curr.size == 0) curr = curr.next;
                DataNode toRemove = curr.head.next;
                remove(toRemove);
                map.remove(toRemove.key);
            }
            DataNode newNode = new DataNode(key, value);
            add2Tail(useHead, newNode);
            map.put(key, newNode);
        }
        // print();
    }
    
    // remove DataNode n from the DataNode list
    private void remove(DataNode n) {
        n.use.size--;
        DataNode prev = n.prev;
        DataNode next = n.next;
        prev.next = next;
        next.prev = prev;
        n.prev = null;
        n.next = null;
        n.use = null;
    }
    
    // add DataNode n to the tail of the DataNode list of u
    private void add2Tail(UseNode u, DataNode n) {
        n.use = u;
        u.size++;
        DataNode prev = u.tail.prev;
        DataNode next = u.tail;
        prev.next = n;
        n.next = next;
        next.prev = n;
        n.prev = prev;
    }
    
    // insert n to the tail of the next DataNode list
    public void increment(DataNode n) {
        UseNode u = n.use;
        remove(n);
        if (u.next == null) {
            u.next = new UseNode(u.use + 1, 0, null);
        }
        add2Tail(u.next, n);
    }
    
    public void print() {
        System.out.println("cache:");
        for (UseNode u = useHead; u != null; u = u.next) {
            System.out.print("counter: " + u.use + ", size: " + u.size + ", data:");
            for (DataNode d = u.head.next; d != u.tail; d = d.next) {
                System.out.print("(" + d.key + "," + d.val + "), ");
            }
            System.out.println();
        }
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

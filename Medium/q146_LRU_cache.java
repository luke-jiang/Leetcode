class LRUCache {
    
    class ListNode {
        int val;
        int key;
        ListNode prev;
        ListNode next;
        public ListNode(int v, int k, ListNode p, ListNode n) {
            val = v; key = k; prev = p; next = n;
        }
        public ListNode(int v, int k) {
            val = v; key = k; prev = null; next = null;
        }
    }
    
    ListNode head;
    ListNode tail;
    Map<Integer, ListNode> map;
    int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        cap = capacity;
        head = new ListNode(-1, -1, null, tail);
        tail = new ListNode(-1, -1, head, null);
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        ListNode node = map.get(key);
        int value = node.val;
        remove(node);
        insertAtEnd(node);
        return value;
    }
    
    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            ListNode node = new ListNode(value, key);
            map.put(key, node);
            insertAtEnd(node);
        } else {
            ListNode node = map.get(key);
            node.val = value;
            remove(node);
            insertAtEnd(node);
        }
        if (map.size() > cap) {
            ListNode toRemove = head.next;
            map.remove(toRemove.key);
            remove(toRemove);
        }
    }
    
    private void remove(ListNode node) {
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
    }
    
    private void insertAtEnd(ListNode node) {
        ListNode prev = tail.prev;
        prev.next = node;
        node.next = tail;
        tail.prev = node;
        node.prev = prev;
    }

    private void printList() {
        System.out.print("[");
        for (ListNode n = head.next; n != tail; n = n.next) {
            System.out.print("(" + n.key + "," + n.val+ ")");
        }
        System.out.println("]");
    }
}

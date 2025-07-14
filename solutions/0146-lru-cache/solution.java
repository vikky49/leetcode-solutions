class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

class LRUCache {

    private final int capacity;
    private final Map<Integer,Node> cache;
    private final Node head;
    private final Node tail; 

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        //create a head dummy Node
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);

        //Make the connections
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {

       //check if the node already existis in the cache
        Node node = cache.get(key);

        if(node != null) {
            // move it to the most Recent used
            //update the value 
            node.value = value;
            moveToHead(node);
        } else {
            //Add the new node 
            Node newNode = new Node(key, value);
            // check the capacity 
            if(cache.size() >= capacity) {
                //Remove the last node which is LRU
                Node lru = tail.prev;
                removeNode(lru);
                cache.remove(lru.key);
            }

            addToHead(newNode);
            cache.put(key, newNode);

        }
        
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

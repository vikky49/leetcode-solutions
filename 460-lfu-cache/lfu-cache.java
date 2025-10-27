/**
 * LFU Cache - CORRECTED VERSION
 * This fixes the eviction bug
 */
class LFUCache {
    
    class Node {
        int key, val, freq;
        
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }
    
    private int capacity, minFreq;
    private Map<Integer, Node> keyToNode;           // key -> Node
    private Map<Integer, LinkedHashSet<Node>> freqToNodes; // frequency -> nodes
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToNode = new HashMap<>();
        this.freqToNodes = new HashMap<>();
    }
    
    public int get(int key) {
        if (!keyToNode.containsKey(key)) {
            return -1;
        }
        Node node = keyToNode.get(key);
        updateFreq(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        
        if (keyToNode.containsKey(key)) {
            // Key exists - update value and frequency
            Node node = keyToNode.get(key);
            node.val = value;
            updateFreq(node);
        } else {
            // Key doesn't exist - need to insert
            if (keyToNode.size() >= capacity) {
                // Cache is full - evict LFU node
                LinkedHashSet<Node> nodes = freqToNodes.get(minFreq);
                Node toRemove = nodes.iterator().next();
                nodes.remove(toRemove);
                keyToNode.remove(toRemove.key);  // Remove from main map
            }
            
            // Insert new node
            Node node = new Node(key, value);
            keyToNode.put(key, node);
            freqToNodes.putIfAbsent(1, new LinkedHashSet<>());
            freqToNodes.get(1).add(node);
            minFreq = 1;
        }
    }
    
    private void updateFreq(Node node) {
        int oldFreq = node.freq;
        LinkedHashSet<Node> oldSet = freqToNodes.get(oldFreq);
        oldSet.remove(node);
        
        // If we just emptied the minFreq bucket, increment minFreq
        if (oldFreq == minFreq && oldSet.isEmpty()) {
            minFreq++;
        }
        
        // Increment frequency and add to new bucket
        node.freq++;
        freqToNodes.putIfAbsent(node.freq, new LinkedHashSet<>());
        freqToNodes.get(node.freq).add(node);
    }
}
/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
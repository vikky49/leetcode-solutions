/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
        if(node == null) {
            return null;
        }
        
        Map<Node,Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        
        Node clone = new Node(node.val);
        visited.put(node,clone);
        queue.offer(node);
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            
            for(Node neighbor : current.neighbors) {
                if(!visited.containsKey(neighbor)) {
                    Node cloneNeigh = new Node(neighbor.val);
                    visited.put(neighbor,cloneNeigh);
                    queue.offer(neighbor);
                }
                
                Node clonedCurrent = visited.get(current);
                Node clonedNeigh = visited.get(neighbor);
                clonedCurrent.neighbors.add(clonedNeigh);
                
            }
                        
        }
        return clone;
        
    }
}
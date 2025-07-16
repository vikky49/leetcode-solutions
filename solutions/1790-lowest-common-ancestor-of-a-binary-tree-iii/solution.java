/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {

        if(p == null || q == null) {
            return null;
        }

        Set<Node> ancestors = new HashSet<>();

        Node current = p;

        while (current != null) {
            ancestors.add(current);
            current = current.parent;
        }

        current = q;
        while (current != null) {
            if(ancestors.contains(current)) {
                return current;
            }
            current = current.parent;
        }
        return null;
    }
}

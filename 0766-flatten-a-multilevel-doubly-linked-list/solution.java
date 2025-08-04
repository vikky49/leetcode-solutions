/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head == null) {
            return null;

        }

        Stack<Node> stack = new Stack<>();
        Node current = head;

        while (current != null) {

            //if there is child we have to process it first 
            if(current.child != null) {
                 
                 //but if the current.next also exists we will push it in the stack and revisit it after the child
                 if(current.next != null) {
                    stack.push(current.next);
                 }

                 //lets process the child Node
                 current.next = current.child;
                 current.child.prev = current;
                 //remove the child pointer 
                 current.child = null;
                 
                 //if we reached the end of the level and 
                 // stack is not empty we need to process that node

             } else if(current.next == null && !stack.isEmpty()) {
                current.next = stack.pop();
                current.next.prev = current;
             } 

             current = current.next;
            
        }

        return head;
        
    }
}

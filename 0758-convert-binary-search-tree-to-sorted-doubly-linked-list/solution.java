/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
     
     Node head = null;
     Node tail = null;

    public Node treeToDoublyList(Node root) {

        if(root == null) {
            return null;
        }

         head = null;
         tail = null;

         inOrder(root);

         //do the final link
         tail.right = head;
         head.left = tail;

         return head;
        
    }

     private void inOrder(Node node) {

        //Base case 
        if(node == null) {
            return;
        }
         //Go all the way to left most 
        inOrder(node.left);

        // Do some processing
        // The very first case the head is null
         if(head == null) {
             head = node;
             tail = node;
         } else {
            // we need to add the node to the tail to make it linked treeToDoublyList
            tail.right = node;
            //then link the previous node to make it doubly linked treeToDoublyList
            node.left = tail;

            tail = node;
         }

        //Process the right node 
        inOrder(node.right);
    }
}

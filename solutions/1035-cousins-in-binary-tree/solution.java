/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null) {
            return false;
        }

        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
        //parent of x 
         Integer px = null;
        //parent of y
          Integer py = null;
            
            int size = queue.size();
            
            for(int i = 0; i < size; i++ ) {
                
              TreeNode current = queue.remove();
                
              if(current.left != null) {
                  queue.add(current.left);
                  
                  if(current.left.val == x) {
                      px = current.val;
                  }
                  
                  if(current.left.val == y) {
                      py = current.val;
                  }
                  
              }
             
             if(current.right != null) {
                 
                 queue.add(current.right);
                 
                 if(current.right.val == x) {
                     px = current.val;
                 }
                 
                 if(current.right.val == y) {
                     py = current.val;
                 }
                 
             }   
                
            }
            
            if(px != null && py != null && px != py) {
                return true;
            }   
        }
        return false;
    }
}

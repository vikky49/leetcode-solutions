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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> levels = new ArrayList<>();
        
        if(root == null) {
            return levels;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        // add the root element in the queue
        queue.add(root);
        
        while(!queue.isEmpty()) {
            
            List<Integer> level = new ArrayList<>();
            
            //get the current size of the queue
            int size = queue.size();
                    
            for(int i = 0 ; i < size ; i++ ) {
            //Remove the element in the queue
            TreeNode current = queue.remove();
            level.add(current.val);     
            
            if(current.left != null) {
                queue.add(current.left);
            }
            
            if(current.right != null) {
                queue.add(current.right);
            }                     
                
          }
            
          levels.add(0,level);   
                        
        }
        
        return levels;
    }
    
}

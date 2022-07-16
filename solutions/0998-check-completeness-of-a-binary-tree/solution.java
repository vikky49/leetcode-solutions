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
    
    
    class TreeNodeWithId {
        TreeNode node;
        int id; // index
     
        TreeNodeWithId(TreeNode node, int id) {
            this.node = node;
            this.id = id;
        }
        
    }
    
    public boolean isCompleteTree(TreeNode root) {
        
        if (root == null) {
            return true;
        }
        
        int expectedId = 1;
        
        Queue<TreeNodeWithId> queue = new LinkedList<>();
        queue.add(new TreeNodeWithId(root,1));
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            
            for (int i=0 ; i < size ; i++) {
                
                TreeNodeWithId current = queue.remove();
                
                TreeNode currentNode = current.node;
                int currentIndex = current.id;
              
                if(expectedId == currentIndex) {
                    expectedId += 1;
                } else {
                  return false;  
                }
                
                if(currentNode.left != null) {
                    
                    queue.add(new TreeNodeWithId(currentNode.left, 2 * currentIndex));
                }
                
                if(currentNode.right != null) {
                    
                    queue.add(new TreeNodeWithId(currentNode.right , 2 * currentIndex + 1));                                              
            }
            
        }
        
    }
    return true;
  }
}

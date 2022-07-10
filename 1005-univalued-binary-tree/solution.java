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
    public boolean isUnivalTree(TreeNode root) {
        
        if(root == null) {
            return false;
        }
        
        int rootValue = root.val;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            
            for(int i=0; i< size ; i++) {
                
                TreeNode current = queue.remove();
                
                if (current.left != null) {
                    queue.add(current.left);
                }
                
                if (current.right != null) {
                   queue.add(current.right); 
                }
                
                if(current.val != rootValue) {
                    return false;
                }
                
            }
        }
        
        return true;
        
    }
}

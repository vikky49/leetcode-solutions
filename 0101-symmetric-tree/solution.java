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
    
    class TreeWithTwoNodes {
        
        TreeNode leftSide;
        TreeNode rightSide;
        
        TreeWithTwoNodes(TreeNode p, TreeNode q) {
            this.leftSide = p;
            this.rightSide = q;
        }
        
    }
    
    public boolean isSymmetric(TreeNode root) {
        
        if(root == null) {
            return true;
        }
        
        Queue<TreeWithTwoNodes> queue = new LinkedList<>();
        queue.add(new TreeWithTwoNodes(root,root));
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            
            for(int i = 0; i < size ; i++) {
                
                TreeWithTwoNodes current = queue.remove();
                
                TreeNode leftpart = current.leftSide;
                TreeNode rightpart = current.rightSide;
                
                //case 1: the left side of left and right side of right should exist
                if(leftpart.left != null && rightpart.right != null) {
                    queue.add(new TreeWithTwoNodes(leftpart.left,rightpart.right));
                }
                 //case2 : either left part or right part of the tree node does not exist
                else if (leftpart.left != null || rightpart.right != null){
                    return false;
                }
                
                if(leftpart.right != null && rightpart.left != null) {
                    queue.add(new TreeWithTwoNodes(leftpart.right,rightpart.left));
                }
                
                else if(leftpart.right != null || rightpart.left != null){
                    return false;
                }
                
                if(leftpart.val != rightpart.val) {
                    return false;
                }
                
            }
            
        }
        return true;
        
    }
}

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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        
        //Edge case 
        
        if(depth == 1) {
            TreeNode node = new TreeNode(val);
            node.left = root;
            root = node;
            return root;
        }
        
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            
            level += 1;
            int size = queue.size();
            
            for(int i = 0 ; i < size; i++ ) {
            
            TreeNode current = queue.remove();
            
             if (current.left != null) {
                 queue.add(current.left);
             }
            
            if (current.right != null) {
                queue.add(current.right);
            }
            
            if (level == depth-1) {
                TreeNode newleft = new TreeNode(val);
                TreeNode newright = new TreeNode(val);
                
                newleft.left = current.left;
                newright.right = current.right;
               
                current.left = newleft;
                current.right = newright;
                
            }
        }
            
            
    }
        return root;
        
    }
}

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
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> largestValues = new ArrayList<>();
        
        if (root == null) {
            return largestValues;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            int largestNum = Integer.MIN_VALUE;
            
            for(int i = 0; i < size ; i++) {
                
                TreeNode current = queue.remove();
                
                largestNum = Math.max(current.val, largestNum);
                
                if(current.left != null) {
                    queue.add(current.left);
                }
                
                if(current.right != null) {
                    queue.add(current.right);
                }
            }
            largestValues.add(largestNum);
        }
        return largestValues;
        
    }
}

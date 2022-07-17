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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> slate = new ArrayList<>();
        
        // Edge Case 
        if(root == null) {
            return results;
        }
        
        dfs(root,targetSum,slate,results);
        
        return results;
    }
    
    
        private void dfs(
            TreeNode node, 
            int target, 
            List<Integer> slate,
            List<List<Integer>> results ) {
            
            //first add the value 
            slate.add(node.val);
            
            target = target - node.val;
            
            //Base Case 
        
            // if node is a leaf node 
            
            if(node.left == null && node.right == null) {
                
                if(target == 0) {
                    results.add(new ArrayList<>(slate));
                }                
            }
            //Recursive case 
            
            if(node.left != null ) {
                dfs(node.left,target, slate, results);
            }
            
            if(node.right != null) {
                dfs(node.right, target, slate, results);
            }
            
            slate.remove(slate.size()-1);
            
        }
        
        
  }

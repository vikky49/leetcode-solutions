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
    
    class TwoTrees {
        
        TreeNode p;
        TreeNode q;
        
        TwoTrees(TreeNode p, TreeNode q) {
            this.p = p;
            this.q = q;
        }
        
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        //base case
        
        if (p == null && q == null) {
            return true;
        }
        
        if(( p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        
        
        TwoTrees twoTrees = new TwoTrees(p,q);
        
        Queue<TwoTrees> queue = new LinkedList<>();
        queue.add(twoTrees);
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            
            for(int i=0 ; i < size ; i++) {
                
                TwoTrees current = queue.remove();
                
                TreeNode tree1 = current.p;
                
                TreeNode tree2 = current.q;
                
                //case 1: both tree nodes have left child
                if(tree1.left != null && tree2.left != null) {
                    queue.add(new TwoTrees(tree1.left, tree2.left));
                }
                //case 2: either left or right subtree does not have a left child
                else if(tree1.left != null || tree2.left!= null) {
                    return false;
                }
                
                //case 3: Both trees have right subchild
                if(tree1.right != null && tree2.right != null) {
                    queue.add(new TwoTrees(tree1.right,tree2.right));
                }
                // Case 4: Either one of the tree does not have the right subtree
                else if (tree1.right != null || tree2.right != null) {
                    return false;
                }
                
                if(tree1.val != tree2.val){
                    return false;
                }
                                            
            }
            
        }
        return true;
                        
    }
}

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
    
    class TreeNodeWithIndex {
        
        TreeNode treeNode;
        int id; // Address of the node 
        
        TreeNodeWithIndex(TreeNode node, int id){
            this.treeNode = node;
            this.id = id;
        }
        
    }
    
    public int widthOfBinaryTree(TreeNode root) {
        
        if(root == null) {
            return 0;
        }
        
       List<Integer> width = new ArrayList<>();
       
        Queue<TreeNodeWithIndex> queue = new LinkedList<>();
        queue.add(new TreeNodeWithIndex(root,1));
        
        while(!queue.isEmpty()) {
            
            int size = queue.size();
            int firstNode = -1;
            int lastNode = -1;
            
            for(int i = 0 ; i < size ; i++) {
                
                TreeNodeWithIndex currentNode = queue.remove();
                
                if(currentNode.treeNode.left != null) {
                    queue.add(
                            new TreeNodeWithIndex(currentNode.treeNode.left,
                                                        2*currentNode.id));
                }
                
                if(currentNode.treeNode.right != null) {
                   queue.add(
                            new TreeNodeWithIndex(currentNode.treeNode.right,
                                                        2*currentNode.id + 1));  
                }
                
                lastNode = currentNode.id;
                
                if(firstNode == -1) {
                    firstNode = currentNode.id;
                }
                
                width.add(lastNode - firstNode + 1);
                
            }
            
        }
        
        return Collections.max(width);
                
    }
}

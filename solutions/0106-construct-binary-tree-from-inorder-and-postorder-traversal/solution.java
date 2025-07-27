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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        Map<Integer,Integer> inOrderMap = new HashMap<>();
        for(int i = 0 ; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return dfs(
            inorder, 
            0, 
            inorder.length -1,
            postorder, 
            0,
            postorder.length - 1,
            inOrderMap);

    }

    private TreeNode dfs(
        int[] inorder,
        int inorderStart,
        int inOrderEnd,
        int[] postorder,
        int postOrderStart,
        int postOrderEnd,
        Map<Integer,Integer> inOrderMap
    ) {

       //Check the boundary conditions
       if(inorderStart > inOrderEnd || postOrderStart > postOrderEnd) {
         return null;
       }

       int rootVal = postorder[postOrderEnd];
       TreeNode treeNode = new TreeNode(rootVal);

       int rootIndex = inOrderMap.get(rootVal);

       int numOfLeft = rootIndex - inorderStart;

       treeNode.left = dfs(
            inorder, 
            inorderStart, 
            rootIndex-1,
            postorder, 
            postOrderStart, 
            postOrderStart + numOfLeft -1 ,
            inOrderMap);

        treeNode.right = dfs(
            inorder, 
            rootIndex+1, 
            inOrderEnd,
            postorder, 
            postOrderStart + numOfLeft, 
            postOrderEnd - 1, // Since root in the last element
            inOrderMap);    
        
    
        
        return treeNode;
    }
}

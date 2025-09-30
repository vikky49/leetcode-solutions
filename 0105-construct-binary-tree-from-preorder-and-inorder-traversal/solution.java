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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inorderIndexMap = new HashMap<>();

        for(int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return dfs(
            preorder, 
            0, 
            preorder.length-1, 
            inorder, 
            0, 
            inorder.length-1, 
            inorderIndexMap);
    }

    private TreeNode dfs(
        int[] preorder,
        int preStart,
        int preEnd,
        int[] inorder,
        int inStart,
        int inEnd,
        Map<Integer,Integer> inOrderIndexMap
    ) {

        //Base case 
        if(preStart > preEnd || inStart > inEnd) {
             return null;
        }

        //Root is always the first node of the preorder
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);

        //In inorder every thing left to the root is the left subtree
        //find the index of the root in the inorder array

        int rootIndex = inOrderIndexMap.get(rootVal);

        int leftSubTreeSize = rootIndex - inStart;

        //Recursively build the leftSubTree

        root.left = dfs(
            preorder, 
            preStart+1, 
            preStart+leftSubTreeSize, 
            inorder, 
            inStart, 
            rootIndex-1, 
            inOrderIndexMap);


        root.right = dfs(
            preorder, 
            preStart+leftSubTreeSize+1, 
            preEnd ,
            inorder, 
            rootIndex + 1,
            inEnd, 
            inOrderIndexMap);

         return root;

    }
}

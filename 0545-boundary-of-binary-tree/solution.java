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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        
        if(root == null) {
            return result;
        }
        result.add(root.val);

        if(isLeafNode(root)) {
            return result;
        }

        addLeftBoundary(root.left,result);

        addLeafNodes(root,result);

        addRightBoundary(root.right,result);

        return result;
        
    }

    private void addLeftBoundary(
        TreeNode node, 
        List<Integer> result) {
        
       TreeNode current = node;

       while(current != null) {
         if(!isLeafNode(current)) {
            result.add(current.val);
         }
         if(current.left != null) {
            current = current.left;
         } else {
            current = current.right;
         }
       }
      
    }

    private void addLeafNodes(
        TreeNode node,
        List<Integer> result) {

      if(node == null) {
         return;
       }

       if(isLeafNode(node)) {
        result.add(node.val);
        return;
       }

       addLeafNodes(node.left, result);
       addLeafNodes(node.right, result);

    }

    private void addRightBoundary(
        TreeNode node,
        List<Integer> result) {

       Stack<Integer> stack = new Stack<>();
        TreeNode current = node;

        while (current != null) {
            if(!isLeafNode(current)){
                stack.push(current.val);
            }
            if(current.right != null) {
                current = current.right;
            } else  {
                current = current.left;
            }
            
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }


    private boolean isLeafNode(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        } 
        return false;
    }
}

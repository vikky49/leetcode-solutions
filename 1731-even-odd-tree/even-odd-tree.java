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
    public boolean isEvenOddTree(TreeNode root) {
        if(root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int level = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int prevValue = level % 2 == 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            for(int i = 0 ; i < levelSize ; i++) {
                TreeNode currentNode = queue.poll();

                //check the level
                if(level % 2 == 0) {
                    //even level
                    //if the value is even and if the value is in decreasing order
                    if(currentNode.val % 2 == 0 || currentNode.val <= prevValue) {
                        return false;
                    }
                } else {
                    // odd level
                    if(currentNode.val % 2 == 1 || currentNode.val >= prevValue) {
                        return false;
                    }
                }

                prevValue = currentNode.val;

                if(currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if(currentNode.right != null) {
                    queue.offer(currentNode.right);
                }

            }
            level ++;
        }

        return true;
        
    }
}
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
    public int closestValue(TreeNode root, double target) {

        // Initialize closest to root value (best we know so far)
        int closest = root.val;

        while (root != null) {
            double currentDistance = Math.abs(root.val - target);
            double closestDistance = Math.abs(closest - target);
            //If there are multiple answers, print the smallest.
            //Hence we choose the smallest 
            if (currentDistance < closestDistance ||
                    (currentDistance == closestDistance &&
                            root.val < closest)) {

                closest = root.val;
            }

            //BST traversal 
            if (target < root.val) {
                root = root.left;

            } else {
                root = root.right;
            }

        }

        return closest;

    }
}
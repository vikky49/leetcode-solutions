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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder pathToStart = new StringBuilder();
        StringBuilder pathToDest = new StringBuilder();

        findPath(root, startValue, pathToStart);
        findPath(root, destValue, pathToDest);

        // Now the prefix for the path -- root - start value 
        // also from root to dest value -- will be the same 

        //Lets remove the path from root to LCA 

        int i = 0;
        while (i < pathToStart.length() && i < pathToDest.length() &&
                pathToStart.charAt(i) == pathToDest.charAt(i)) {
            i++;
        }

        StringBuilder result = new StringBuilder();

        // Add 'U's for going up from start to LCA
        for (int j = i; j < pathToStart.length(); j++) {
            result.append('U');
        }

        // Add path from LCA to dest
        result.append(pathToDest.substring(i));

        return result.toString();

    }

    private boolean findPath(
            TreeNode node,
            int target,
            StringBuilder path) {
        if (node == null) {
            return false;
        }

        if (node.val == target) {
            return true;
        }

        path.append('L');
        if (findPath(node.left, target, path)) {
            return true;
        }

        path.deleteCharAt(path.length() - 1);

        path.append('R');

        if (findPath(node.right, target, path)) {
            return true;
        }

        path.deleteCharAt(path.length() - 1);

        return false;
    }
}
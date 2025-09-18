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
    private int totalCount = 0;
    private List<Integer> slate = new ArrayList<>();

    public int sumNumbers(TreeNode root) {

        if (root == null) {
            return 0;
        }
        dfs(slate, root);
        return totalCount;

    }

    private void dfs(
            List<Integer> slate,
            TreeNode node) {

        //add to the slate 
        slate.add(node.val);

        //Base case 
        if (node.left == null && node.right == null) {
            long pathNum = 0;
            for (int i = 0; i < slate.size(); i++) {
                pathNum = pathNum * 10 + slate.get(i);
            }
            totalCount += pathNum;
        } else {

            if (node.left != null) {
                dfs(slate, node.left);
            }

            if (node.right != null) {
                dfs(slate, node.right);
            }

        }

        //backtrack
        slate.removeLast();

    }
}
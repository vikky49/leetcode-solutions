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
    public void recoverTree(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorderTraversal(root, values);

        Collections.sort(values);

        int[] index = { 0 };

        resoreTree(root, values, index);

    }

    private void resoreTree(
            TreeNode node,
            List<Integer> values,
            int[] index) {
        if (node == null) {
            return;
        }
        resoreTree(node.left, values, index);
        node.val = values.get(index[0]++);
        resoreTree(node.right, values, index);
    }

    private void inorderTraversal(TreeNode node, List<Integer> nodes) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left, nodes);
        nodes.add(node.val);
        inorderTraversal(node.right, nodes);
    }

}

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
    public int findClosestLeaf(TreeNode root, int k) {

        if (root == null) {
            return -1;
        }

        Map<Integer, TreeNode> byVal = new HashMap<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();

        buildParentMap(
                root,
                null,
                byVal,
                parentMap);

        TreeNode startNode = byVal.get(k);
        queue.offer(startNode);
        seen.add(startNode);

        while (!queue.isEmpty()) {

            TreeNode curr = queue.poll();

            //Leaf node
            if (curr.left == null && curr.right == null) {
                return curr.val;
            }

            if (curr.left != null && !seen.contains(curr.left)) {
                seen.add(curr.left);
                queue.offer(curr.left);
            }

            if (curr.right != null && !seen.contains(curr.right)) {
                seen.add(curr.right);
                queue.offer(curr.right);
            }

            TreeNode parent = parentMap.get(curr);
            if (parent != null && !seen.contains(parent)) {
                seen.add(parent);
                queue.offer(parent);
            }

        }

        return -1;

    }

    private void buildParentMap(
            TreeNode node,
            TreeNode parent,
            Map<Integer, TreeNode> byVal,
            Map<TreeNode, TreeNode> parentMap) {

        if (node == null) {
            return;
        }

        byVal.put(node.val, node);
        parentMap.put(node, parent);

        buildParentMap(node.left, node, byVal, parentMap);
        buildParentMap(node.right, node, byVal, parentMap);

    }
}
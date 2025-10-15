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
    public int findDistance(TreeNode root, int p, int q) {

        Map<Integer, TreeNode> byVal = new HashMap<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentValueMap(
                root,
                null,
                byVal,
                parentMap);

        //BFS traversal 
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();

        TreeNode src = byVal.get(p);
        TreeNode dst = byVal.get(q);

        if (src == null || dst == null) {
            return 0;
        }

        queue.offer(src);
        seen.add(src);
        int distance = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode currNode = queue.poll();

                if (currNode == dst) {
                    return distance;
                }

                if (currNode.left != null && !seen.contains(currNode.left)) {
                    queue.offer(currNode.left);
                    seen.add(currNode.left);
                }

                if (currNode.right != null && !seen.contains(currNode.right)) {
                    queue.offer(currNode.right);
                    seen.add(currNode.right);
                }

                TreeNode parent = parentMap.get(currNode);
                if (parent != null && !seen.contains(parent)) {
                    queue.offer(parent);
                    seen.add(parent);
                }
            }
            distance++;

        }

        return -1;

    }

    private void buildParentValueMap(
            TreeNode node,
            TreeNode parent,
            Map<Integer, TreeNode> byVal,
            Map<TreeNode, TreeNode> parentMap) {
        if (node == null) {
            return;
        }

        byVal.put(node.val, node);
        parentMap.put(node, parent);
        buildParentValueMap(node.left, node, byVal, parentMap);
        buildParentValueMap(node.right, node, byVal, parentMap);
    }
}
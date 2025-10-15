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
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, TreeNode> byVal = new HashMap<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        buildValueParentMap(
                root,
                null,
                byVal,
                parentMap);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();

        int minitues = -1;

        TreeNode src = byVal.get(start);
        if (src == null) {
            return 0;
        }

        queue.offer(src);
        seen.add(src);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if(curr.left != null && !seen.contains(curr.left)) {
                    seen.add(curr.left);
                    queue.offer(curr.left);
                }


                if(curr.right != null && !seen.contains(curr.right)) {
                    seen.add(curr.right);
                    queue.offer(curr.right);
                }

                TreeNode parent = parentMap.get(curr);
                if(parent != null && !seen.contains(parent)) {
                    seen.add(parent);
                    queue.offer(parent);
                }
            }
            minitues++;

        }
        return Math.max(0, minitues);

    }

    private void buildValueParentMap(
            TreeNode node,
            TreeNode parent,
            Map<Integer, TreeNode> byVal,
            Map<TreeNode, TreeNode> parentMap) {

        if (node == null) {
            return;
        }
        byVal.put(node.val, node);
        parentMap.put(node, parent);
        buildValueParentMap(node.left, node, byVal, parentMap);
        buildValueParentMap(node.right, node, byVal, parentMap);
    }
}
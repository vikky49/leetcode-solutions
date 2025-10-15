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

        Map<Integer, TreeNode> byVal = new HashMap<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();

        buildValueParentMap(
                root,
                null,
                byVal,
                parentMap);

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> seen = new HashSet<>();

        Map<TreeNode, Character> move = new HashMap<>();
        Map<TreeNode, TreeNode> prev = new HashMap<>();

        TreeNode src = byVal.get(startValue);
        TreeNode dst = byVal.get(destValue);

        if (src == null || dst == null) {
            return "";
        }

        if (src == dst) {
            return "";
        }

        queue.offer(src);
        seen.add(src);

        while (!queue.isEmpty()) {

            TreeNode curNode = queue.poll();

            if (curNode == dst) {
                //Lets build the path later here 
                StringBuilder sb = new StringBuilder();
                TreeNode node = dst;
                while (node != src) {
                    Character step = move.get(node);
                    if (step == null) {
                        break;
                    }
                    sb.append(step);
                    node = prev.get(node);
                }
                return sb.reverse().toString();

            }

            if (curNode.left != null && !seen.contains(curNode.left)) {
                queue.offer(curNode.left);
                seen.add(curNode.left);
                move.put(curNode.left, 'L');
                prev.put(curNode.left, curNode);

            }

            if (curNode.right != null && !seen.contains(curNode.right)) {
                queue.offer(curNode.right);
                seen.add(curNode.right);
                move.put(curNode.right, 'R');
                prev.put(curNode.right, curNode);
            }

            TreeNode parent = parentMap.get(curNode);

            if (parent != null && !seen.contains(parent)) {
                queue.offer(parent);
                seen.add(parent);
                move.put(parent, 'U');
                prev.put(parent, curNode);

            }

        }
        return "";

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
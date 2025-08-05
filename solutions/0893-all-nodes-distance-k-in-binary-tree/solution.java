/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parentMap = new HashMap<>();
        buildParentMap(root,null,parentMap);

        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(target);
        visited.add(target);
        int distance = 0;

        while (!queue.isEmpty() && distance < k) {
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                //check left child
                if(current.left != null && !visited.contains(current.left)) {
                    queue.offer(current.left);
                    visited.add(current.left);
                }

                if(current.right != null && !visited.contains(current.right)) {
                    queue.offer(current.right);
                    visited.add(current.right);
                }

                TreeNode parent = parentMap.get(current);
                if(parent != null && !visited.contains(parent)){
                    queue.offer(parent);
                    visited.add(parent);
                }
            }
            distance ++;
        }
            
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }
   
       return result;
        
    }




    private void buildParentMap(
        TreeNode node,
        TreeNode parent,
        Map<TreeNode,TreeNode> parentMap
    ) {

        if(node == null) {
            return;
        }

       parentMap.put(node, parent);
       buildParentMap(node.left, node, parentMap);
       buildParentMap(node.right, node, parentMap);
    }
}

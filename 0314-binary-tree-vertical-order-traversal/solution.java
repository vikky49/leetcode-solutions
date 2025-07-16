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
    public List<List<Integer>> verticalOrder(TreeNode root) {

        if(root == null) {
            return new ArrayList<>();
        }

        int minColumn = 0;
        int maxColumn = 0;

        Queue<Pair<Integer,TreeNode>> queue = new LinkedList<>();
        Map<Integer,List<Integer>> columnMap = new HashMap<>();

        //start with root Node which is 0
        queue.offer(new Pair<>(0, root));

        while (!queue.isEmpty()) {
            Pair<Integer,TreeNode> pair = queue.poll();
            
            int column = pair.getKey();
            TreeNode node = pair.getValue();

            //Add it to the map for the column map
            columnMap.computeIfAbsent(column, k -> new ArrayList<>())
                         .add(node.val);

            
             minColumn = Math.min(minColumn, column);
             maxColumn = Math.max(maxColumn, column);

             if(node.left != null) {
                queue.offer(new Pair<>(column-1, node.left));
             }

             if(node.right != null) {
                queue.offer(new Pair<>(column+1, node.right));
             }            
        } 

        List<List<Integer>> result = new ArrayList<>();

        for(int i= minColumn; i <= maxColumn ; i++) {
           result.add(columnMap.get(i));
        }

        return result;
    }
}

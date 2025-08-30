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

  static class Pair<T, U> {
        T first;
        U second;
        
        Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }     
    }


    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        if(root == null) {
            return List.of();
        }

        List<List<Integer>> result = new ArrayList<>();
     
        TreeMap<Integer, List<Pair<Integer, Integer>>> map = new TreeMap<>();
             
             //(treeNode,(row,col))
        Queue<Pair<TreeNode,Pair<Integer,Integer>>> queue = new LinkedList<>();

        queue.offer(new Pair(root,new Pair<>(0, 0)));

        while (!queue.isEmpty()) {
            
            Pair<TreeNode,Pair<Integer,Integer>> current = queue.poll();
            TreeNode currentNode = current.first;
            Pair<Integer,Integer> rowColPair = current.second;

            int row = rowColPair.first;
            int col = rowColPair.second;

            map.computeIfAbsent(col, k -> new ArrayList<>())
                  .add(new Pair(row, currentNode.val));

            if(currentNode.left != null) {
                queue.offer(new Pair(currentNode.left, new Pair(row + 1, col - 1)));
            }     

            if(currentNode.right != null) {
                queue.offer(new Pair(currentNode.right, new Pair(row + 1, col + 1)));
            }   
            
        }

       
       for(List<Pair<Integer,Integer>> column: map.values()) {
            column.sort((a, b) -> a.first != b.first ? 
                                    a.first - b.first : 
                                    a.second - b.second);

            List<Integer> vals = new ArrayList<>();
            for(Pair<Integer,Integer> colPair : column) {
                  vals.add(colPair.second);
            }

            result.add(vals);

       }

     
      return result;
        
    }
}

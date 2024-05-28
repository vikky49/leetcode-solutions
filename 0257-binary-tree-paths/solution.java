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
    public List<String> binaryTreePaths(TreeNode root) {
        //Edge case
        if(root == null) {
           return Collections.emptyList();
        }
        List<String> paths = new LinkedList<>();
        buildPaths(root,"",paths);
        return paths;        
    }

    private void buildPaths(
        TreeNode root,
        String path,
        List<String> paths
    ) {
     
     // add the first element to the path
     path += Integer.toString(root.val);

     //Base Case  (leaf nodes)
      if(root.left == null && root.right == null) {
          paths.add(path);
      }

      //Recursive case
      path += "->";
      if(root.left != null) {
        buildPaths(root.left, path, paths);
      }

      if(root.right != null) {
        buildPaths(root.right, path, paths);
      }

    }
}

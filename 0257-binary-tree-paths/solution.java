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

        if(root == null) {
            return List.of();
        }

        List<Integer> slate = new ArrayList<>();
        List<String> paths = new ArrayList<>();

        dfs(root,slate,paths);

        return paths;

                 
    }

    private void dfs(
        TreeNode node,
        List<Integer> slate,
        List<String> paths
    ) {

        if(node == null) {
            return;
        }

        //add the current value to the current paths
        slate.add(node.val);

        //Base case 
        if(node.left == null && node.right == null) {
            //This is leaf node so lets calculate the path here
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < slate.size(); i++) {
                if(i > 0) {
                    sb.append("->");
                }
                sb.append(slate.get(i));
            }

            paths.add(sb.toString());
        } else {
            dfs(node.left, slate, paths);
            dfs(node.right, slate, paths);
        }

        //Backtrack
        slate.removeLast();

    }
}

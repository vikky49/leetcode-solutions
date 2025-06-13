class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;
        
        int[] pathSumCount = {0}; // Use array to pass by reference
        List<Integer> slate = new ArrayList<>();
        dfs(root, targetSum, slate, pathSumCount);
        return pathSumCount[0];
    }

    private void dfs(
        TreeNode node, 
        int target, 
        List<Integer> slate,
        int[] count) {
 
        slate.add(node.val);

        long suffixSum = 0;
        for(int i = slate.size() - 1; i >= 0; i--) { // Start from current node
            suffixSum += slate.get(i);
            if(suffixSum == target) {
                count[0]++;
            }
        }

        if(node.left != null) {
            dfs(node.left, target, slate, count);
        }

        if(node.right != null) {
            dfs(node.right, target, slate, count);
        }

        slate.remove(slate.size() - 1); // Use remove(index) instead of removeLast()
    }
}

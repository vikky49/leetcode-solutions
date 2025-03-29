# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> int:

        if root is None:
            return 0

        globalCount = [0]

        def dfs(node, target, slate):
            # append the node to the slate so that we know the list of ancestors at every node to calculate the sum
            slate.append(node.val)
            # This slate has all the values from the current node to all the way to the root. Lets also maintain a suffix sum to maintain a running sum
            suffixSum = 0
            for i in range(len(slate)-1, -1, -1):
                suffixSum += slate[i]
                if suffixSum == target:
                    globalCount[0] += 1

            if node.left is not None:
                dfs(node.left, target, slate)

            if node.right is not None:
                dfs(node.right, target, slate)

            slate.pop()

        dfs(root, targetSum, [])
        return globalCount[0]

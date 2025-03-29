# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root is None:
            return []
        result = []

        def dfs(node, target, slate):
            slate.append(node.val)
            target = target - node.val

            # BaseCase
            if node.left is None and node.right is None:
                # Append the copy
                if target == 0:
                  result.append(slate[:])

            # Recursive Case
            if node.left is not None:
                dfs(node.left, target, slate)

            if node.right is not None:
                dfs(node.right, target, slate)

            # you have to pop the slate to remove the last state
            slate.pop()

        dfs(root, targetSum, [])
        return result


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        if root is None:
            return None
        
        def dfs(node):

            #Base case. If the node is a leaf- we might not have to do any thing
            if node.left is None and  node.right is None:
                pass
            
            #Recursive Case
            oldLeft = node.left
            oldRight = node.right

            #Do a swap here
            node.left = oldRight
            node.right = oldLeft

            if node.left is not None:
                dfs(node.left)
            
            if node.right is not None:
                dfs(node.right)

        dfs(root)
        return root        
        

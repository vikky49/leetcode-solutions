# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def longestConsecutive(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        
        globalAns = [0]

        def dfs(node,pval,lengthSofar):

            if(node.val == pval+1):
                lengthSofar += 1
            else:
                lengthSofar = 1

            if lengthSofar > globalAns[0]:
                globalAns[0] = lengthSofar
            
            #Recursive Cas
            if node.left is not None:
                dfs(node.left,node.val,lengthSofar)
            if node.right is not None:
                dfs(node.right,node.val,lengthSofar)

        dfs(root,root.val,1)        
        return globalAns[0]

               
        

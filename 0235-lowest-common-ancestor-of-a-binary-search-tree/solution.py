# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        #value of p
        p_val = p.val

        #value of q
        q_val = q.val

        node = root

        #Traverse the node
        while node:
            parent_val = node.val

            if p_val > parent_val and q_val > parent_val:
                node = node.right
            elif p_val < parent_val and q_val < parent_val:
                node = node.left

            else:
                #since both the conditions fail now we know this is the split point  aka the LCA node 
                return node
        

class Solution:
    def removeKdigits(self, num: str, k: int) -> str:
        stack = []

        for digit in num:
            while stack and k > 0 and stack[-1] > digit:
                stack.pop()
                k -= 1
            stack.append(digit)

        # Trunk the remaining K digits if they exist at the end 
        finalStack = stack[:-k] if k else stack

        return "".join(finalStack).lstrip('0') or "0"
        

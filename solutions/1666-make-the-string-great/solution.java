class Solution {
    public String makeGood(String s) {
        
        //Lets use stack to store the characters
        
        Stack<Character> stack = new Stack<>();
        
        for(char curChar : s.toCharArray()) {
            
            if( !stack.isEmpty() && Math.abs(stack.lastElement() -curChar) == 32) {
                
                stack.pop();
 
            } else {
                
                stack.push(curChar);
            }
            
        }
        
        //concat the string 
        
        StringBuilder result = new StringBuilder();
        for(char curr : stack) {
            result.append(curr);
        }
        
        return result.toString();
        
    }
}

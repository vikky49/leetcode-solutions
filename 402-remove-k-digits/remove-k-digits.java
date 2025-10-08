class Solution {
    public String removeKdigits(String num, int k) {

        if (num == null || num.length() == 0 || k >= num.length()) {
            return "0";            
        }

        Stack<Character> stack = new Stack<>();

        for(char ch : num.toCharArray()) {

        
        while(!stack.isEmpty() && k > 0 && stack.peek() > ch ) {
            stack.pop();
            k--;
        }
            stack.push(ch);

        }
 
        //if k is still greater than 0
        while(k > 0) {
            //pop the last elements
            stack.pop();
            k--;

        }

        StringBuilder sBuilder = new StringBuilder();
        for(char ch : stack) {
            sBuilder.append(ch);
        }
        
        //Remove any leading zeros

        int i = 0;
        while (i < sBuilder.length() && sBuilder.charAt(i) == '0') {
            i++;
            
        }

        String result = sBuilder.substring(i);
        return result.isEmpty() ? "0" : result;
        
    }
}
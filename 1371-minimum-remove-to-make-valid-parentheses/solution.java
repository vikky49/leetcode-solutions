class Solution {
    public String minRemoveToMakeValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                if(!stack.isEmpty()) {
                    //valid pair
                    stack.pop();
                } else {
                    //found the invalid pair
                    chars[i] = '*';
                }
            }
        }

       //update the remaining characters 
        while (!stack.isEmpty()) {
            chars[stack.pop()] = '*';
        }

        StringBuilder stringBuilder = new StringBuilder();
        
        for(char c : chars) {
            if(c != '*')  {
                stringBuilder.append(c);
            }

        }
      
        return stringBuilder.toString();
        
    }
}

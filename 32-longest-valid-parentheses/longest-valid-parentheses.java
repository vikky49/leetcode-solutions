class Solution {
    public int longestValidParentheses(String s) {

        if (s == null || s.length() < 2) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] valid = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                //push index - 
                stack.push(i);
            } else {
                // its closing 
                //but if the stack is  not empty 
                if (!stack.isEmpty()) {
                    // Its a valid pair
                    int openIndex = stack.pop();
                    valid[openIndex] = true;
                    valid[i] = true;
                }
            }

        }

        //Now pass 2 
        int currentLength = 0;
        int maxLength = 0;

        for (boolean isvalid : valid) {
            if (isvalid) {
                currentLength++;
                maxLength = Math.max(currentLength, maxLength);
            } else {
                currentLength = 0; //Reset
            }
        }

        return maxLength;

    }
}
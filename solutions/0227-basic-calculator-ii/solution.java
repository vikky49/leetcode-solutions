class Solution {
    public int calculate(String s) {

        if(s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        char op = '+';
        //start with num as 0
        int num = 0;

        for(int i =0 ; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            // else if Character is an operator
            if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || i == s.length()-1) {
                switch (op) {
                    case '+':
                         stack.push(num);
                        break;

                    case '-':
                         stack.push(-num);
                         break;

                    case '*':
                        stack.push(stack.pop() * num);
                        break;

                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                
                    default:
                        break;
                }
                 op = ch; //store the current  operator for next iteration
                 num = 0;
            }
        }

        int result = 0;
        for (int n : stack) {
            result += n;
        }

        return result;

        
    }
}

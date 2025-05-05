class Solution {
    public int evalRPN(String[] tokens) {
        // Init the stack 
        Stack<Integer> stack = new Stack<>();
        String operators = "+-*/";
          for(String token : tokens) {
           
          if(!operators.contains(token)) {
            stack.push(Integer.valueOf(token));
            continue;
          }

          int number_2 = stack.pop();
          int number_1 = stack.pop();
          int result = 0;

          switch (token) {
            case "+":
                result = number_1 + number_2;
                break;

            case "-":
                result = number_1 - number_2;
                break;
            
            case "*":
                result = number_1 * number_2;
                break;
            
            case "/":
                result = number_1 / number_2;
                break;
         
          }

          stack.push(result);

        }
        return stack.pop();
        
    }
}

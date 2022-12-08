class Solution {
    public boolean isValid(String s) {

        Map<Character,Character> map = new HashMap<>();
         map.put(')', '(');
         map.put('}', '{');
         map.put(']', '[');

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);

      // If the current character is a closing bracket.
        if (map.containsKey(c)) {
        // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
        char topElement = stack.empty() ? '#' : stack.pop();
        // If the mapping for this bracket doesn't match the stack's top element, return false.
        if (topElement != map.get(c)) {
          return false;
        }
      } else {
        // If it was an opening bracket, push to the stack.
        stack.push(c);
      }
    }

    // If the stack still contains elements, then it is an invalid expression.
    return stack.isEmpty();
  }
}

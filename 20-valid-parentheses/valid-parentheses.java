class Solution {
    public boolean isValid(String s) {

        Stack<Character> open = new Stack<>();

        for (char c : s.toCharArray()) {
            // if opening 
            if (c == '(' || c == '{' || c == '[') {
                open.push(c);
            } else {
                //closing 
                //closing bracket is there but no open - false 
                if (open.isEmpty()) {
                    return false;
                }

                char top = open.pop();
                if (!isPair(top, c)) {
                    return false;
                }

            }
        }

        return open.isEmpty();

    }

    private boolean isPair(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '{' && close == '}')
                || (open == '[' && close == ']');
    }
}
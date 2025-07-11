class Solution {
    public int calculate(String s) {
        int sum = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();

        for(int i=0 ; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                int val = 0;
                //keep looping as long as its a digit
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + (s.charAt(i) - '0');
                    i++;
                }
                sum += val * sign;
                sign = 1; 
                i--;

            } else if(ch == '-') {
                sign = -1;

            } else if(ch == '+') {
                sign = 1;

            } else if(ch == '(') {
                //if its a new '(' then we create a new slate
                stack.push(sum);
                stack.push(sign);
                //reset the sum here 
                sum = 0;
                sign = 1;

            } else if(ch == ')') {

                int prevSign = stack.pop();
                int prevSum = stack.pop();

                sum = (sum * prevSign) + prevSum;


            }
        }

        return sum;
        
    }
}

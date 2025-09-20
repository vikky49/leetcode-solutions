class Solution {
    public String decodeString(String s) {

        Stack<StringBuilder> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        int num = 0;
        StringBuilder current = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(num);
                stringStack.push(current);

                //After pushing this we are going to reset
                current = new StringBuilder();
                num = 0;

            } else if (ch == ']') {
                int repeatTimes = countStack.pop();
                StringBuilder prevBuilder = stringStack.pop();
                for(int i = 0; i < repeatTimes; i++) {
                     prevBuilder.append(current);

                }
                current = prevBuilder;

            } else {
                current.append(ch);

            }
        }

        return current.toString();

    }
}

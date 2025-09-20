class Solution {
    public String removeDuplicates(String s) {

        Stack<Pair<Character, Integer>> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (!stack.isEmpty() && stack.peek().getKey() == c) {
                Pair<Character, Integer> top = stack.pop();
                stack.push(new Pair<>(c, top.getValue() + 1));

                //if the count reaches k elements 
                if (stack.peek().getValue() == 2) {
                    stack.pop();
                }

            } else {
                stack.push(new Pair<>(c, 1));

            }

        }

        StringBuilder sb = new StringBuilder();
        for (Pair<Character, Integer> pair : stack) {
            char c = pair.getKey();
            int value = pair.getValue();

            sb.append(String.valueOf(c).repeat(Math.max(0, value)));

        }

        return sb.toString();

        
    }
}

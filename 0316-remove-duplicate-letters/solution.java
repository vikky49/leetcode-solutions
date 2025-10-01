class Solution {
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> count = new HashMap<>();
        Set<Character> visited = new HashSet<>();
        Stack<Character> stack = new Stack<>();

        //Count frequency 
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            //Decrement count
            count.put(c, count.get(c) - 1);

            //skip if its already visited
            if (visited.contains(c)) {
                continue;
            }

            while (!stack.isEmpty() &&
                    stack.peek() > c &&
                    count.get(stack.peek()) > 0) {
                visited.remove(stack.pop());
            }

            stack.push(c);
            visited.add(c);
        }

        //Build the result
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();

    }
}

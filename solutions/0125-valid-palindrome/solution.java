class Solution {
    public boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();

        char[] charArray = s.toCharArray();

        for(Character ch : charArray) {
            if(Character.isLetterOrDigit(ch)) {
                char normalized = Character.toLowerCase(ch);
                stack.push(normalized);
                queue.offer(normalized);
            }
        }

        //compare the queue with stack 

        while (!stack.isEmpty()) {
            if(stack.pop() != queue.poll()) {
                return false;
            }
        }
        return true;        
    }
}

class Solution {
    public String reverseWords(String s) {

        if(s == null || s.length() == 0) {
            return s;
        }

        Stack<String> stack = new Stack<>();

        String[] words = s.trim().split("\\s+");

        for(String word : words) {
             if (word.length() > 0) {
                stack.push(word);
             }
        }

        StringBuilder builder = new StringBuilder();

        while (!stack.isEmpty()) {
            builder.append(stack.pop());
            //Now add the space 
            if (!stack.isEmpty()) {
                builder.append(" ");
            }
        }
    
      return builder.toString();
        
    }
}
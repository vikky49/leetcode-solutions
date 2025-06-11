class Solution {
    public String reverseVowels(String s) {
        
        if(s == null || s.isEmpty()) {
            return s;
        }

        Stack<Character> stack = new Stack<>();

        char[] charsequence = s.toCharArray();

        for(char c : charsequence) {
            if(isVowel(c)) {
                stack.push(c);
            }
        }

        for(int i = 0; i < charsequence.length; i++) {
            if(isVowel(charsequence[i])) {
                charsequence[i] = stack.pop();
            }

        }
       
       return new String(charsequence);
        
    }

    private boolean isVowel(char c) {
      return "aeiouAEIOU".indexOf(c) != -1;
    }
}

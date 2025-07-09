class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> charCount = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        int maxFreq = 0;

        for(int right = 0; right < s.length(); right++) {
           char rightChar = s.charAt(right);

           //Expand the window
           charCount.put(rightChar, charCount.getOrDefault(rightChar, 0) + 1);
           maxFreq = Math.max(maxFreq, charCount.get(rightChar));

           //calculate the replacements here 
           int windowSize = right - left + 1;
           int replacementsNeeded = windowSize - maxFreq;

             //shrink the window
           if (replacementsNeeded > k) {
              char leftChar = s.charAt(left);
              charCount.put(leftChar, charCount.get(leftChar) - 1);
              left ++;
           }

           maxLength = Math.max(maxLength, right-left+1);

        }  
        return maxLength;  

        
    }
}

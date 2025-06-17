class Solution {
    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        int maxVowels = 0;
        int windowCount = 0;

        boolean[] isVowel = new boolean[128]; // ASCII table size
        isVowel['a'] = isVowel['e'] = isVowel['i'] = isVowel['o'] = isVowel['u'] = true;


        for(int i = 0; i < k; i++) {
            if(isVowel[chars[i]]) {
                windowCount ++;
            }
        }

        maxVowels = windowCount;

        for(int i = k; i < s.length(); i++) {
          
          //slide the window
           
          if (isVowel[chars[i]]) {
               windowCount ++;
          }

          if(isVowel[chars[i-k]]) {
               windowCount --;
          }

          maxVowels = Math.max(windowCount, maxVowels);
          
        }

        return maxVowels;
        
    }

     //private boolean isVowel(char c) {
     //   return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    //}

}

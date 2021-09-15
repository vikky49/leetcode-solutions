class Solution {
    public String reverseOnlyLetters(String s) {
        int start = 0;
        int end = s.length() - 1;
        char[] charArray = s.toCharArray();
            
        while ( start < end ) {
            if(!isEnglishChar(charArray[start])){
                start ++ ;
                continue;
            }
            
            if(!isEnglishChar(charArray[end])){
                end --;
                continue;
            }  
               
           //swap 
             char temp = charArray[start];
             charArray[start] = charArray[end];
             charArray[end] = temp;
             start ++;
             end -- ;
        }
               
       return new String(charArray);        
               
    }
    
    private boolean isEnglishChar(char c) {
        return Character.isUpperCase(c) || Character.isLowerCase(c);
    }
}

class Solution {
    public void reverseWords(char[] s) {

        //First lets reverse the whole input and then reverse the words one by one 

        int start_index = 0;
        int end_index = s.length-1;

        swap(s, start_index, end_index);

        //At this point the whole array is reversed 
        // Now lets reverse each word 

        int start = 0;
        int end = 0;
        int n = s.length;
        while(start < n) {
            //Go to the end of the word
            while (end < n && s[end] != ' ') {
               end++;   
            }
            //we have the end of the word
            //end-1 is important here because the end is the space. We should retain its position there
            swap(s, start, end-1);
            //new Start and end are the words that start after the space 
            start = end +1;        
            ++end;
    
        }
        //we need to start the start + 1 to move the space 
        
    }

    private void swap(char[] s, int start, int end) {
        while (start < end) {
        char temp = s[start];
        s[start++] = s[end];
        s[end--] = temp;    
      }
        
    }
}

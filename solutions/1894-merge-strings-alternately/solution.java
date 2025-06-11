class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int l_pointer = 0; 
        int r_pointer = 0;

        StringBuilder result = new StringBuilder();

        while (l_pointer < n || r_pointer <  m) {
            
            if(l_pointer < n) {
                result.append(word1.charAt(l_pointer++));
            }

            if(r_pointer < m) {
                result.append(word2.charAt(r_pointer++));
            }
        }

        return result.toString();
        
    }
}

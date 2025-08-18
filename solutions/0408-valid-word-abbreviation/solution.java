class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        //This is a two pointer solution 
        int wp = 0; //word Pointer
        int ap = 0; //abbr pointer

        while (wp < word.length() && ap < abbr.length()) {
            char current = abbr.charAt(ap);

            //Case 1 : If the current is character
            if(Character.isLetter(current)) {
                //compare the two letters 
                if(word.charAt(wp) != current) {
                    return false;
                }

                //Move the pointers
                wp++;
                ap++;
            }

            else if(Character.isDigit(current)) {
                //Leading 0's are not allowed. So we can return false
                if (current == '0') {
                    return false;
                }

                int skipCount = 0;
                while(ap < abbr.length() && Character.isDigit(abbr.charAt(ap))) {
                    int digit = abbr.charAt(ap) - '0';
                  // Standard algorithm to build multi-digit number from left to right
                    // Example: parsing "123"
                    // First iteration: skipCount = 0 * 10 + 1 = 1
                    // Second iteration: skipCount = 1 * 10 + 2 = 12  
                    // Third iteration: skipCount = 12 * 10 + 3 = 123
                    skipCount = skipCount * 10 + digit;

                    ap++;
   
                } 
                // Now that we built the skipCount lets ignore those number of digits from the word skipCount
                wp += skipCount;

                if(wp > word.length()) {
                    return false;
                }
            } else {
                return false;
            }

        }

        return wp == word.length() && ap == abbr.length();
        
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if(strs.length == 0 || strs == null) {
            return "";
        }

        int minLength = Integer.MAX_VALUE;
        //find the min String so that we dont run over flow errors 
        for(String str: strs) {
          if(str.length() < minLength) {
            minLength = str.length();
          }
        }

        int i = 0;
        while (i < minLength) {
            for(String str : strs) {               
                //compare every character of the string with another 
                if (str.charAt(i) != strs[0].charAt(i)) { 
                    return strs[0].substring(0,i);
                }
            }
            i++;
        }
        return strs[0].substring(0,i);
        
    }
}

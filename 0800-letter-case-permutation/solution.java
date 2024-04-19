class Solution {
    public List<String> letterCasePermutation(String input) {
        
        var results = new ArrayList<String>();
        
        helper(input,0,new char[input.length()],results);
        
        return results;
        
    }
    
    void helper(
        String input,
        int pos, 
        char[] slate, 
        List<String>results) {
        
        //Base case (leaf node)
        
        if (pos == input.length()) {
            results.add(new String(slate));
            return;
        }
        
        // recursive cases 
        
        //get the current character
        char ch = input.charAt(pos);
        
        if(Character.isLetter(ch)) {
            
            slate[pos] = Character.toLowerCase(ch);
            
            helper(input,pos+1,slate,results);
            
            slate[pos] = Character.toUpperCase(ch);
            
            helper(input,pos+1,slate,results);            
            
        } else {
            slate[pos] = ch;
            helper(input, pos+1, slate, results);
        }
        
        
        
    }
}

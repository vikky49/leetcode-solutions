class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        //Edge case 
        if(digits == null || digits.length() == 0) {
            return result;
        }
        
        Map<Character,String> phoneMap = Map.of(
            '2' , "abc",
            '3' , "def",
            '4' , "ghi",
            '5' , "jkl",
            '6' , "mno",
            '7' , "pqrs",
            '8',  "utv",
            '9', "wxyz"
         
          );
        
        StringBuilder slate = new StringBuilder();
        
        backtrack(
            result,
            digits,
            0,
            slate,
            phoneMap
        );
        
        return result;                
        
    }
    
    private void backtrack(
        List<String> result,
        String digits,
        int index,
        StringBuilder slate,
        Map<Character,String> phoneMap
    ) {
        
        //Base case 
        if(index == digits.length()) {
            result.add(slate.toString());
            return;
        }
        
        String letters = phoneMap.get(digits.charAt(index));
        
        for(char c : letters.toCharArray()) {
            //make a choice 
            slate.append(c);
            //backtrack
            backtrack(
             result,
             digits,
             index + 1,
             slate,
             phoneMap             
            );
          
            //remove from the state
            slate.deleteCharAt(slate.length() - 1);
            
        }
        
    }
}

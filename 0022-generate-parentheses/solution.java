class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder slate = new StringBuilder();

        backtrack(result, slate, n, n);

        return result;
    }

    void backtrack(
        List<String> result,
        StringBuilder slate,
        int open,
        int close
    ) {

        //Base case 
     
         if(open == 0 && close == 0) {
            result.add(slate.toString());
            return;
         }

        //Recursive case 
        //At every step there are 2 steps to make a choice 
         
         if(open > 0) {
            //append the open brace when we still have open left 
            slate.append('(');
            backtrack(result, slate, open-1, close);
            //backtrack - where we delete and bring back the slate to the last state

            slate.deleteCharAt(slate.length()-1);
         }

         if(close > open) {
            slate.append(')');
            backtrack(result, slate, open, close-1);
            //backtrack - where we delete and bring back the slate to the last state

            slate.deleteCharAt(slate.length()-1);
         }

    }

    
}


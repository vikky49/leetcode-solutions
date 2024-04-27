class Solution {
    public List<String> generateParenthesis(int n) {
        var result = new ArrayList<String>();
        helper("",n,n,result);
        return result;
    }
    
    private void helper(
        String slate,
        int leftPairs,
        int rightPairs,
        List<String> results
    ) {
        
        //backtracking case 
        if (leftPairs > rightPairs || leftPairs < 0 || rightPairs < 0) {
            return;
        }
        
        //Base case 
        if (leftPairs == 0 && rightPairs == 0 ) {
            results.add(slate);
            return;
        }
        
        helper(slate + "(" , leftPairs-1, rightPairs, results);
        helper(slate + ")", leftPairs, rightPairs-1,results);
        
    }
}

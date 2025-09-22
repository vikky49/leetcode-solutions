class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> slate = new ArrayList<>();
        
        backtrack(result,slate,candidates,target,0);
        
        return result;
        
    }
    
    private void backtrack(
        List<List<Integer>> result,
        List<Integer> slate,
        int[] candidates,
        int target,
        int start
    ) {
        
        //Base case 
        if(target == 0) {
         result.add(new ArrayList<>(slate));
         return;
        }
        
        if(target < 0) {
            return;
        }
        
        
        for(int i=start ; i < candidates.length; i++) {
            
            slate.add(candidates[i]);
            
            backtrack(result,slate,candidates,target-candidates[i],i);
            
            slate.removeLast();
        }
    }
}

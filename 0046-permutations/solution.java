class Solution {
    public List<List<Integer>> permute(int[] nums) {
      
       List<List<Integer>> result = new ArrayList<>();
    
       List<Integer> slate = new ArrayList<>();
       boolean[] used = new boolean[nums.length];
       backtrack(
           nums,
           result,
           slate,
           used
       );
      
       return result;
        
    }
    
    private void backtrack(
      int[] nums,
      List<List<Integer>> result,
      List<Integer> slate,
      boolean[] used
    ) {
        
        if(slate.size() == nums.length) {
            result.add(new ArrayList<Integer>(slate));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(used[i]) {
                continue;
            }
            
            used[i] = true;
            slate.add(nums[i]);
            
            backtrack(
                nums,
                result,
                slate,
                used
            );
            
           //backtrack  
           slate.removeLast();
           
           used[i] = false;
          
        }
        
    }
    
        
}

class Solution {
    public List<List<Integer>> permute(int[] nums) {

     //For all the exhaustive problems we need two things 
      
    var result = new ArrayList<List<Integer>>();
    
    //A temporary snapshot of the data for the dfs

    var slate = new ArrayList<Integer>();

     backtrack(nums,0,slate,result);

     return result;
        
    }

    private void backtrack(
        int[] nums,
        int pos,
        List<Integer> slate,
        List<List<Integer>> result
    ) {

        //Base case 

        if(nums.length == pos) {
            result.add(new ArrayList<Integer>(slate));
            return;
        }

        //Recursive case 
        for(int i = 0 ; i < nums.length ; i++) {
            if(!slate.contains(nums[i])) {
                slate.add(nums[i]);
                backtrack(nums, pos+1, slate, result);
                slate.remove(slate.size() - 1);
            }
        }
    }
}

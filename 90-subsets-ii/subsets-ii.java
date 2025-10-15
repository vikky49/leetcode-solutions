class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        if(nums == null || nums.length == 0) {
            return List.of();
        }

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> slate = new ArrayList<>();

        //Since we are handling duplciates lets sort the ArrayList
        Arrays.sort(nums);

        backtrack(nums,0,result,slate);

        return result;
        
    }

    private void backtrack(
        int[] nums, 
        int start, 
        List<List<Integer>> result, 
        List<Integer> slate) {

        //Base case 
        
        result.add(new ArrayList<>(slate));

        //Recursive case 
        for(int i = start; i < nums.length; i++) {
            //Skip the duplciates 
            if (i > start && nums[i] == nums[i-1]) {
                continue;
            }

            //Add to the slate
            slate.add(nums[i]);

            //backtrack
            backtrack(nums, i+1, result, slate);

            //Remove the last element - reset the slate for backtracking
            slate.removeLast();
        }
    }
}
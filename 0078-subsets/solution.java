class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        var result = new ArrayList<List<Integer>>();

        //slate 
        var slate = new ArrayList<Integer>();
        
        //backtracking Solution

        backtrack(nums,0,slate,result);

        return result;
    }

    private void backtrack(
        int[] nums,
        int pos,
        List<Integer> slate,
        List<List<Integer>> result
    ) {

        //Base case is the leaf node 
        // If the size of the array is reached we know its leaf 

        if(pos == nums.length) {
            result.add(new ArrayList<>(slate));
            return;
        }

        // Recursive case - two cases 
        // case 1 - we ignore the current node 

        // we do nothing here 
        backtrack(nums, pos+1, slate, result);

        //Case 2 where we add the element 
        int element = nums[pos];
        slate.add(element);

        backtrack(nums, pos+1, slate, result);

        //bring back the position to original value 
        //This is equal to removing the last element
        slate.remove(slate.size() - 1);

    }
}

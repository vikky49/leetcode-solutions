class Solution {
    public List<List<Integer>> permute(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        var slate = new ArrayList<Integer>();
        boolean[] used = new boolean[nums.length];

        backtrack(nums, slate, result, used);

        return result;

    }

    private void backtrack(
            int[] nums,
            List<Integer> slate,
            List<List<Integer>> result,
            boolean[] used) {

        //base case 
        if (slate.size() == nums.length) {
            //add the slate to the result
            result.add(new ArrayList<>(slate));
            return;
        }
        //for all the possible next elements
        for (int i = 0; i < nums.length; i++) {
            //skip the element if used 

            if (used[i]) {
                continue;
            }

            //process the next element
            //Add to the slate 
            used[i] = true;
            slate.add(nums[i]);

            backtrack(nums, slate, result, used);

            //Undo the process when we come back 
            slate.removeLast();
            used[i] = false;

        }

    }
}
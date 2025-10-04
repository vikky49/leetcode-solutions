class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        var result = new ArrayList<List<Integer>>();
        var slate = new ArrayList<Integer>();

        if(nums == null || nums.length == 0) {
            return result;
        }
       
        boolean[] used = new boolean[nums.length];

        Arrays.sort(nums);
        
        backtrack(
            result,
            slate,
            used,
            nums
        );
       
        return result;
        
    }

    private void backtrack(
        List<List<Integer>> result,
        List<Integer> slate,
        boolean[] used,
        int[] nums
    ) {

        //Base case 
        if (slate.size() == nums.length) {
            result.add(new ArrayList<>(slate));
            return;
        }

        //Try all the possible elements
        for(int i = 0; i < nums.length; i++) {

            //Critical section of the code 
            if(used[i] || (i > 0 && nums[i] == nums[i-1] && !used[i-1])) {
                continue;
            }

            //Add to slate
            used[i] = true;
            slate.add(nums[i]);

            backtrack(result, slate, used, nums);

            slate.removeLast();
            used[i] = false;

        }

    }
}
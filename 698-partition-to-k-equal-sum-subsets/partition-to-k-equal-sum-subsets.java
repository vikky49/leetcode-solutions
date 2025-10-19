

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) {
            return false;
        }

        int targetSum = sum / k;

        List<Integer> numsList = new ArrayList<>();
        for (int num : nums) {
            numsList.add(num);
        }

        numsList.sort(Collections.reverseOrder());

        if (numsList.getFirst() > targetSum) {
            return false;
        }

        boolean[] used = new boolean[numsList.size()];

        return backtrack(numsList, used, 0, k, targetSum, 0);

    }

    private boolean backtrack(
            List<Integer> nums,
            boolean[] used,
            int startIndex,
            int k,
            int targetSum,
            int currentSum) {

        //Basecase 
        //All the cases are complete
        if(k == 1) {
            return true;
        }

        if(currentSum == targetSum) {
            //Decrement k - start with a new fresh Subset
           return backtrack(nums, used, 0, k-1, targetSum, 0);
        }

        //Try to add elements to the current Subset
        for(int i = startIndex; i < nums.size(); i++) {

            if(used[i] || currentSum + nums.get(i) > targetSum) {
                continue;
            }

           //Avoid duplicates
            if(i > startIndex && nums.get(i).equals(nums.get(i-1)) && !used[i-1]) {
                continue;
            }
      

           used[i] = true;
           //Recurse 
           if(backtrack(nums, used, i+1, k, targetSum, currentSum + nums.get(i))) {
              return true;
           }
           
           //Remove from the slate
           used[i] = false;

           if(currentSum == 0) {
            return false;
           }


        }

        return false;
    }

}
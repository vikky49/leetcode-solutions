class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        //Check for the base case 

        if (nums == null || nums.length < 4) {
            return result;
        }

        // Sort the arrays
        Arrays.sort(nums);

        int n = nums.length;

        //We do two loops 

        for (int i = 0; i < n - 3; i++) {

            //We can skip the duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1; //start from the next to Jth element
                int right = n - 1; //right most element 

                while (left < right) {

                    long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        result.add(Arrays.asList(
                                nums[i],
                                nums[j],
                                nums[left],
                                nums[right]));

                        //Resolve the duplicates
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;

                        }

                        left++;
                        right--;
                    }

                }

            }
        }
        return result;

    }
}

//sorting solution
/* class Solution_SortedArray {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        // loop through every odd element by stepping plus 2
        for(int i= 1; i < nums.length - 1; i+=2) {
            swap(nums, i, i+1);
        }

    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
} */

class Solution {
    public void wiggleSort(int[] nums) {
        for(int i=0; i<nums.length-1; i++) {

            if(i%2 ==0) {
                if(nums[i] > nums[i+1]) {
                  swap(nums, i, i+1);
                }

            } else {
                if(nums[i] < nums[i+1]) {
                    swap(nums, i, i+1);
                }
            }

        }
    }

      private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

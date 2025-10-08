class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
    
        while (left <= right) {
         int mid = left + (right - left) / 2 ;

         //Found the target
         if (nums[mid] == target) {
            return mid;
         }

         //Determine which half is sorted

         if(nums[left] <= nums[mid]) {
            //left half is sorted
            if(target >= nums[left] && target <= nums[mid]) {
                //target is in the sorted left 
                right = mid - 1;
            } else {
                //else target is in the right
                left = mid + 1;
            }
         } else {
            if(target >= nums[mid] && target <= nums[right]) {
                //target in the right half 
                left = mid + 1;
            } else {
                right = mid - 1; //target in the left
            }
         }
            
        }

        return -1;
        
    }
}


class Solution {
    public void nextPermutation(int[] nums) {

        //Base case 
        if (nums == null || nums.length <= 1) {
            return;
        }

        int n = nums.length;
        int pivotElement = -1;

      // Find the first element from the right thats is decreasing from the right 
        for(int i = n-2; i>=0; i--) {
            if(nums[i] < nums[i+1]) {
                pivotElement = i;
                break;
            }
        }

        //If there is no pivot all of them are in reverse order so we blindly reverse them  

         if(pivotElement == -1) {
            reverse(nums,0,n-1);
            return;
         }

         //find the successor . the smallest element greater than pivot
          
          int successor = -1;
          for(int i = n-1; i > pivotElement; i--) {
            if(nums[i] > nums[pivotElement]) {
                successor = i;
                break;
            }
          }
        
        //swap the pivot with the successor
        swap(nums, pivotElement, successor);

        //reverse the elements in between
        reverse(nums, pivotElement+1, n-1);

                
    }

        private void swap(int nums[],int i , int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private void reverse(int nums[],int start, int end) {
            while (start < end) {
                swap(nums, start, end);
                start++;
                end--;
            }
        }
}

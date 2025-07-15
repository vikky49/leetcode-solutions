class Solution {
    public int findClosestNumber(int[] nums) {
        //start with the first one 
        int closestNumber = nums[0];
        int smallestDistance = Math.abs(nums[0]);

        for(int num : nums) {
            int currentNumber = num;
            int currentDistance = Math.abs(currentNumber);
           
           //First check for the smallest number in the sequence 
           if(currentDistance < smallestDistance) {
             closestNumber = currentNumber;
             smallestDistance = currentDistance;
           }
           //if we encounter the same number some where and 
           //its equal to currentDistance which is same as the previous one then we see if the number is greater 
           else if(currentDistance == smallestDistance && 
                   currentNumber > closestNumber) {
                    closestNumber = currentNumber;
                   }
    }
    return closestNumber;
 }
}

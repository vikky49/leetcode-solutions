class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                //the actual indexs are 0 based so we add one to them 
                return new int[] {left+1, right+1};
            }else if(sum > target) {
                right --;
            } else if(sum < target) {
                left ++;
            }
             
        }
            //return -1 and -1 when there is no solution
            return new int[] {-1,-1};
        
    }
}

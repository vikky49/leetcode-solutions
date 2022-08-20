class Solution {
    
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        
        // initialization code 
        
        double windowSum = 0;
        int count = 0;
        
        for(int i = 0; i < k ; i++ ) {
            windowSum += arr[i];
        }
        
        if(windowSum >= k * threshold) {
            count += 1;
        }
        
        // now compute the values for every sliding window 
        
        for(int i = k ; i < arr.length ; i++) {
            
            //i-k removing the last element in the sliding window
            windowSum += arr[i] - arr[i-k];
            
            if(windowSum >= k * threshold){
                count+=1;
            }
                        
        }
        return count;
                
    }
}

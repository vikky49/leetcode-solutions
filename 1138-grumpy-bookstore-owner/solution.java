class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        
        // initlization
        
        // the goal is to find the number of maximum dissatifised customers to maximize those minutes
        
        int numOfAngry = 0;
        int globalMax = 0;
        int satisfiedCustomers = 0;
        for(int i = 0; i< minutes ; i++) {
            if( grumpy[i] == 1) {
                numOfAngry += customers[i];
            }
        }
        globalMax = numOfAngry;
        
        // lets also find the total number of satisfied customers here 
        
        for(int i = 0; i< customers.length ; i++ ) {
            if(grumpy[i] == 0) {
                satisfiedCustomers += customers[i];
            }
        }
        
        
        //calculate for each sliding window and update the angry customers
        
        for(int i= minutes ; i< customers.length ; i++) {
        
            if(grumpy[i] == 1) {
                numOfAngry += customers[i];
            }
            
            if(grumpy[i-minutes] == 1) {
                numOfAngry -= customers[i-minutes];
            }
            
            //we updated the max number of angry customers
            globalMax = Math.max(globalMax,numOfAngry);
                        
        }
        
        return globalMax + satisfiedCustomers;
                
    }
}

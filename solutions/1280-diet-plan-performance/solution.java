class Solution {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        
        //set up the first sliding window -- initialization
        
        double calorieWindowSum = 0;
        int points = 0;
        
        for(int i = 0; i< k ; i++ ) {
            calorieWindowSum += calories[i];
        }
        
        if(calorieWindowSum > upper) {
            points += 1;
        }
        
        if(calorieWindowSum < lower) {
            points -= 1;
        }
        
        
        //calculate the sliding windows
        for(int i=k ; i < calories.length ; i++ ) {
            
            //get the new window sum
            calorieWindowSum += calories[i] - calories[i-k];
            
            if(calorieWindowSum > upper) {
                points += 1;
            }
            
            if(calorieWindowSum < lower) {
                points -= 1;
            }
            
        }
        
        return points;
        
    }
}

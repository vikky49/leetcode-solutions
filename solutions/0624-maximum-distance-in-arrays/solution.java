class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
/*
Properties we know 
1. We know that the Array is sorted. So instead of brute force we know what the min and max of each array is which makes it easy
2. We start with a min_value and max_value with the first array and loop through all the arrays calculate the result at every step in the loop and also update the latest min and max value 

*/ 

    int result = 0;
    //we start with the first array in the array of arrays
    int min_value = arrays.get(0).getFirst();
    int max_value = arrays.get(0).getLast();

    // Now lets start from index 1 

    for (int i = 1 ; i < arrays.size() ; i++) {
       
       int start = arrays.get(i).getFirst(); //min
       int end = arrays.get(i).getLast(); //max

       int diff1= Math.abs(end-min_value);
       int diff2 = Math.abs(start - max_value);

       int curr_result = Math.max(diff1, diff2);

       result = Math.max(result, curr_result);

       min_value = Math.min(start,min_value);
       max_value = Math.max(end,max_value);

    }

    return result;
        
 }

}

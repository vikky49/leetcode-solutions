class Solution {
    public List<Integer> intersection(int[][] nums) {

        Map<Integer,Integer> countMap = new HashMap<>();
        int totalLength = nums.length;
        
         for(int[] arr : nums) {
           
           Set<Integer> seen  = new HashSet<>();    
            
            for(int num : arr) {
                if(!seen.contains(num)) {
                    countMap.put(num, countMap.getOrDefault(num, 0) + 1);
                    seen.add(num);
                }
            }
         }
         
         List<Integer> result = new ArrayList<>();
         for(Map.Entry<Integer,Integer> entry : countMap.entrySet()) {
            if(entry.getValue() == totalLength) {
                result.add(entry.getKey());
            }
         }

         Collections.sort(result);

         return result;
        
    }
}

class Solution {
    
    private Map<Integer,Integer> memo = new HashMap<Integer,Integer>();
    
    public int minCostClimbingStairs(int[] cost) {
        return minimumCost(cost.length, cost);
    }
    
    private int minimumCost(int i, int[] cost) {
       
        if(i <= 1) {
           return 0;
        }
        
        if(memo.containsKey(i)) {
            return memo.get(i);
        }
        
        //cache them
        int stepOne = cost[i-1] + minimumCost(i-1, cost);
        int stepTwo = cost[i-2] + minimumCost(i-2, cost);
        memo.put(i,Math.min(stepOne,stepTwo));
        return memo.get(i);
        
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        //answer array to the size of temperatures length
        int[] answer = new int[n];
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int curDay = 0 ; curDay < n ; curDay++) {
            
            int currentTemp = temperatures[curDay];
            
            while(!stack.isEmpty() && temperatures[stack.peek()] < currentTemp) {
                int prevDay = stack.pop();
                answer[prevDay] = curDay - prevDay;
            }
            
            stack.push(curDay);
        }
        
        return answer;
        
    }
}

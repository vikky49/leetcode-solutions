class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        var results = new ArrayList<List<Integer>>();
        
        var slate = new ArrayList<Integer>();
        
        helper(nums,0,slate,results);
        
        return results;
                
    }
    
    void helper(
        int[] input,
        int pos,
        List<Integer> slate,
        List<List<Integer>> results
    ) {
        
        // Base case
        if(pos == input.length) {
            results.add(new ArrayList<>(slate));
            return;
        }
        
        //Recursive cases 
        int element = input[pos];
        
        //include the element
        slate.add(element);
        helper(input,pos+1,slate,results);
        slate.remove(slate.size() -1 );
        
        //exclude the element
        
        helper(input,pos+1,slate, results);
        
        
    }
}

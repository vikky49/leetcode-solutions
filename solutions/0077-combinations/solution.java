class Solution {
    public List<List<Integer>> combine(int n, int k) {

        var result = new ArrayList<List<Integer>>();

        var slate = new ArrayList<Integer>();

        backtrack(n, k, result, slate);

        
        return result;
        
    }

    private void backtrack(
        int n,
        int k,
        List<List<Integer>> result,
        List<Integer> slate
    ) {

    // Base case 
     
     if(slate.size() == k) {
       result.add(new ArrayList<>(slate));
       return;
     }

     // Recursive case 

     int left = n;
     int still_need = k - slate.size();

     //if we need to pick more than we have we can skip the left path 
     if(left > still_need) {
        backtrack(n-1, k, result, slate);
     }

    // lets pick the right side of the tree
     
    slate.add(n);
    backtrack(n-1, k, result, slate);
    slate.remove(slate.size() - 1);

    }
}

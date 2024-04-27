class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        var results = new ArrayList<List<Integer>>();
        var combo = new LinkedList<Integer>();
        helper(target,combo,0,candidates,results);
        return results;
    }

    private void helper(
            int remain,
            LinkedList<Integer> combo,
            int start,
            int[] candidates,
            List<List<Integer>> results
    ) {

        //Back Tracking case or base case
          if(remain == 0) {
              results.add(new ArrayList<>(combo));
              return;
          } else if (remain < 0) {
              return;
          }

        //Recursive case

        for(int i = start ; i < candidates.length ; i++) {
            combo.add(candidates[i]);
            helper(
                    remain - candidates[i],
                    combo,
                    i,
                    candidates,
                    results);
            combo.removeLast();
        }
        
    }
}


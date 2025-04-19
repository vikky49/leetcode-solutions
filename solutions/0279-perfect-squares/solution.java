class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        int count =1 ;
        while(count * count <= n) {
            int sq = count * count ;

            for (int i = sq; i <= n ; i++) {
                dp[i] = Math.min(dp[i],1+dp[i-sq]);
            }
            count++;
        }
        return dp[n];
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int []r:dp){
        Arrays.fill(r,-1);
        }
        int ans=helper(n-1,coins,amount,dp);
        return ans >= (int)1e9 ? -1 : ans;
    }
    private int helper(int last,int[] coins,int amt,int[][] dp){

            if(last==0){
                if(amt%coins[0]==0) return amt/coins[0];
                return  (int)1e9;
            }
            if(dp[last][amt]!=-1){
                return dp[last][amt];
            }

        int pick=(int)1e9;
        if(coins[last]<=amt){
         pick=1+helper(last,coins,amt-coins[last],dp);
        }
        int notpick=helper(last-1,coins,amt,dp);
        
            return dp[last][amt]= Math.min(pick,notpick);
    }

}
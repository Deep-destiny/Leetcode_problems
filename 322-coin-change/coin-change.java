class Solution {
    public int coinChange(int[] coins, int amount) {
        // min number of coins needed to make amount
        int[][]dp= new int[coins.length][amount+1];
        for(int []r:dp){
        Arrays.fill(r,-1);
        }
        int ans=rec(0,amount,coins,dp);
        return ans>=(int)1e9?-1:ans;
    }
    private int rec(int idx,int amount,int[] coins,int[][] dp){
        if(amount==0)return 0;
         if(idx==coins.length) return (int)1e9;
        if(dp[idx][amount]!=-1) return dp[idx][amount];
       

        int pick=(int)1e9;
        if(coins[idx]<=amount){
        pick=1+rec(idx,amount-coins[idx],coins,dp);
        }
        int notpick=rec(idx+1,amount,coins,dp);
        return dp[idx][amount]=Math.min(pick,notpick);

    }
}
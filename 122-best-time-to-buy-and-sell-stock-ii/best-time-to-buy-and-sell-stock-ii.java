class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int [][] dp=new int [n][2];
        for(int []r:dp){
        Arrays.fill(r,-1);
        }
        return rec(0,1,prices,n,dp);
    }

    private int rec(int ind,int buy,int []prices,int n,int[][]dp){
        if(ind==n) return 0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        int profit=0;
        if(buy==1){
            profit=Math.max(   -prices[ind] + rec(ind+1,0,prices,n,dp),
                                0+rec(ind+1,1,prices,n,dp)
                );
        }
        else{
            profit=Math.max(   prices[ind]+rec(ind+1,1,prices,n,dp),
                                0+rec(ind+1,0,prices,n,dp)
            );
        }
        return dp[ind][buy]= profit;
    }
}
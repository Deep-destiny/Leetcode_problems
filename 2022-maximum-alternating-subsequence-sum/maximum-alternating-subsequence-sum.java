class Solution {
    public long maxAlternatingSum(int[] nums) {
        
        Long [][]dp=new Long[nums.length+1][2];
        return solve(nums,0,false,dp);
    }
    long solve(int[]nums,int idx,boolean flag,Long [][]dp){
        if(idx>=nums.length) return 0;
        if(dp[idx][flag?1:0]!=null) return dp[idx][flag?1:0] ;
        long skip=solve(nums,idx+1,flag,dp);
        
        int val=nums[idx];
        if(flag) val=-val;
        long take=val+solve(nums,idx+1,!flag,dp);

        return  dp[idx][flag?1:0]=Math.max(take,skip);
    }
}
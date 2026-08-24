class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n=nums.length;
        int[][]dp =new int[n+1][target+1];
        for(int []t:dp){
        Arrays.fill(t,-1);
        }
        return solve(0,target,nums,dp);
    }
    int solve(int idx,int target,int[] nums,int[][]dp){
        if(target==0) return 1;
          if(idx>=nums.length || target<0) return 0;
        if(dp[idx][target]!=-1) return dp[idx][target];
      
        int take=solve(0,target-nums[idx],nums,dp);
        int not_take=solve(idx+1,target,nums,dp);

        return dp[idx][target]=take+not_take;
    }
}
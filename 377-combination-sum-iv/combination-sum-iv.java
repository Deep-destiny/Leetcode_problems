class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n=nums.length;
        int[][]dp =new int[n+1][target+1];
       
        for(int i=0;i<=n;i++)dp[i][0]=1;

       
            for(int t=1;t<=target;t++){
                 for(int idx=n-1;idx>=0;idx--){
                int not_take=dp[idx+1][t];

                int take=0;
                if(t>=nums[idx]){
                    take=dp[0][t-nums[idx]];
                }
                dp[idx][t]=take+not_take;
            }
        }
        return dp[0][target];
    }
}
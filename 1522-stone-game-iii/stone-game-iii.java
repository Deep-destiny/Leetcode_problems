class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        // int []dp=new int[n+1];
        // Arrays.fill(dp,-1);

        int [] dp=new int[n+1];
        Arrays.fill(dp,-1);
        int diff= fn(0,stoneValue,dp);
        if(diff>0) return "Alice";
        else if(diff<0) return "Bob";
        else return "Tie";
    }
    private int fn(int i,int []nums,int[] dp){
        int n=nums.length;
        if(i>=n) return 0;
        // int sum=0;
        // for(int num:nums) sum+=num;
        // if(i==j) return nums[i];
        if(dp[i]!=-1) return dp[i];

        int take=nums[i]-fn(i+1,nums,dp);
         if(i+1<n){
         take=Math.max(take,nums[i]+nums[i+1]-fn(i+2,nums,dp));
         }
         if(i+2<n){
         take=Math.max(take,nums[i]+nums[i+1]+nums[i+2]-fn(i+3,nums,dp));
         }
         return dp[i]=take;
    }
    }
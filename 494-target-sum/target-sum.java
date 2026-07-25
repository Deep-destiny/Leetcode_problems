class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        int totalSum=0;
        for(int x:nums) totalSum+=x;
        if(target > totalSum) return 0;
        if((target+totalSum)%2 !=0 || (target+totalSum )<0) return 0;
        int rt=(target+totalSum)/2;

        int t[][]=new int[n+1][rt+1];
        t[0][0]=1;
        for(int j=1;j<=rt;j++){
            t[0][j]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=0;j<=rt;j++){
                if(nums[i-1]<=j){
                    t[i][j]=t[i-1][j] + t[i-1][j-nums[i-1]];
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][rt];
    }
}
class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }

        if(sum%2==0){
            int W=sum/2;
return fn(nums,W,n);
        } 
        else{
            return false;
        }
    }
    private boolean fn(int[]nums,int W,int n){
 boolean t[][]=new boolean[n+1][W+1];
 for(int i=0;i<n+1;i++){
    t[i][0]=true;
 }
 for(int j=1;j<W+1;j++){
    t[0][j]=false;
 }

for(int i=1;i<n+1;i++){
    for(int j=1;j<W+1;j++){
        
        if(nums[i-1]<=j){
            t[i][j]=t[i-1][j] || t[i-1][j-nums[i-1]];
        }
        else{
            t[i][j]=t[i-1][j];
        }
    }
}
return t[n][W];
}
}
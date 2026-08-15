class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0 )return 0;
        int []t=new int[n+1];
        Arrays.fill(t,-1);
            return solve(0,nums,n,t);
            
    }
    private int solve(int i,int[] nums,int n,int []t){
       
        if(i>=n) return 0;
        if(t[i]!=-1) return t[i];
        int take=nums[i]+solve(i+2,nums,n,t);
        int skip=solve(i+1,nums,n,t);
        
        return t[i]=Math.max(take,skip);
    }
}
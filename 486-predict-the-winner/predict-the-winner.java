class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        int t[][]=new int[n+1][n+1];
        for(int []r:t){
            Arrays.fill(r,-1);
        }
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        return sum-fn(0,n-1,nums,t)<= fn(0,n-1,nums,t)? true:false;
    }
    private int fn(int i,int j,int[] nums,int [][]t){
        if(i>j) return 0;
        if(i==j) return nums[i];
        if(t[i][j]!= -1) return t[i][j];
        int take_i= nums[i]+Math.min(fn(i+2,j,nums,t),fn(i+1,j-1,nums,t));
        int take_j= nums[j]+Math.min(fn(i+1,j-1,nums,t), fn(i,j-2,nums,t));

        return t[i][j]=Math.max(take_i,take_j);
    }
}
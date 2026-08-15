class Solution {
    public int waysToSplitArray(int[] nums) {
        int n=nums.length;
        int cnt=0;
        long []pre =new long[n+1];
        for(int i=0;i<n;i++){
            pre[i+1]=pre[i]+nums[i];
        }
       
        for(int j=1;j<n;j++){
            if(pre[j]>=(pre[n]-pre[j])) cnt++;
            
        }
        return cnt;
    }
}
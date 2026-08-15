class Solution {
    public int waysToSplit(int[] nums) {
        int MOD=1000000007;
        int N=nums.length;
        long []pre=new long[N+1];
        for(int i=0;i<N;i++){
            pre[i+1]=pre[i]+nums[i];
        }
        long cnt=0;
        int left=1;
        int right=0;
        for(int j=2;j<=N-1;j++){
            
            //s2<=s3
            // pre[j]-pre[i]<=pre[N]-pre[j]
            //2*pre[j]-pre[n]<=pre[i]
            while(left<j && pre[left]<2*pre[j]-pre[N]){
                left++;
            }
            // s1<=s2
            // pre[i]<=pre[j]-pre[i]
            //2*pre[i]<=pre[j]
            while(right+1<j && 2*pre[right+1]<=pre[j]){
                right++;
            } 
           if(left<=right){
            cnt+=right-left+1;
           }
        }

return (int)(cnt%MOD);
    }
}
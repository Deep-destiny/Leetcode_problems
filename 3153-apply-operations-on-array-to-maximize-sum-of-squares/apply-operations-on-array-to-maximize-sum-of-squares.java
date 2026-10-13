class Solution {
    final int MOD=1000000007;
    public int maxSum(List<Integer> nums, int k) {
        final int BITS=30;

        int[]count=new int[BITS];
        for(int num:nums){
            for(int b=0;b<BITS;b++){
                if((num & (1<<b))!=0) count[b]++;
            }
        }
        long res=0;
        while(k-->0){
            long curr=0;
            for(int b=0;b<BITS;b++){
                if(count[b]>0){
                count[b]--;
                curr|=(1<<b);
            }
            }
        res=(res+curr*curr)%MOD;
    }
    return (int)res;
}
}
class Solution {
    public long[] resultArray(int[] nums, int k) {
        long [] result=new long[k];
        long [] prevcount=new long[k];

        for(int i=0;i<nums.length;i++){

            long[] currcount=new long[k];

            int currElementRem=nums[i]%k;
            currcount[currElementRem]++;

            for(int oldRem=0;oldRem<k;oldRem++){
                int newRem= (int)( ( (long) oldRem * nums[i]%k)%k);
                currcount[newRem]+=prevcount[oldRem];
            }
            prevcount=currcount;
            for(int x=0;x<k;x++){
                result[x]+=currcount[x];
            }
        }
        return result;
    }
} 
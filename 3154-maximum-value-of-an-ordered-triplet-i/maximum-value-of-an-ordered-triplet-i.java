class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        long maxA=nums[0];
        long minA=nums[0];
        long maxDiff=Long.MIN_VALUE;
        long minDiff=Long.MAX_VALUE;
        Long ans=Long.MIN_VALUE;

        for(int k=1;k<n;k++){
            if(k>=2){
                long d1=maxA-nums[k-1];
                long d2=minA-nums[k-1];
                maxDiff=Math.max(maxDiff,Math.max(d1,d2));
                minDiff=Math.min(minDiff,Math.min(d1,d2));

                long value1=maxDiff*nums[k];
                long value2=minDiff*nums[k];

                ans=Math.max(ans,Math.max(value1,value2));
            }
            maxA=Math.max(nums[k],maxA);
            minA=Math.min(nums[k],minA);
        }
        return ans;
    }
}
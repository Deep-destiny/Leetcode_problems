class Solution {
    public int longestOnes(int[] nums, int k) {
        int max_len=0;
        int zeros=0;
        int l=0;
        int r=0;
        int n=nums.length;
        while(r<n){
            if(nums[r]==0) zeros++;
            if(zeros>k){

            if(nums[l]==0) zeros--;
            l++;
        }
        if(zeros<=k){
            int len=r-l+1;
            max_len=Math.max(max_len,len);
        }
        r++;
    }
    return max_len;
    }
}
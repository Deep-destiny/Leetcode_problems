class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
       int l=0;
       int n=nums.length;
       int r=0;
       int sum=0;
       int res=0;
       int zero_cnt=0;
       while(r<n){
        sum+=nums[r];
        while(l<r && (nums[l]==0 || sum>goal)){
            if(nums[l]==0) zero_cnt++;
            else zero_cnt=0;
            sum-=nums[l];
            l++;
        }
        if(sum==goal){
            res+=1+zero_cnt;
        }
        r++;
       }
       return res;
    }
}
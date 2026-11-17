class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        int odd=0;
        int l=0;
        int r=0;
        int zero_cnt=0;
        int res=0;
        int sum=0;
          while(r<n){
            sum+=nums[r]%2;
            while(l<r && (nums[l]%2==0 || sum> k))
            {
                if(nums[l]%2==0) zero_cnt++;
                else zero_cnt=0;
                sum-=nums[l]%2;
                l++;
            }
            if(sum==k){
                res+=1+zero_cnt;
            }
            r++;
          }
          return res;
    }
}
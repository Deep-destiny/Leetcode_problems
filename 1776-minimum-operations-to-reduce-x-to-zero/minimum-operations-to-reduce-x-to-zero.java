class Solution {
    int cnt;
    public int minOperations(int[] nums, int x) {
        // new approach 
        // sliding window
        int n=nums.length;
        int total_sum=0;
        for(int num:nums) total_sum+=num;
        int target=total_sum-x;
        if(target<0) return -1;
        if(target==0) return n;
        int max_Len=-1;
        int currSum=0;
        int left=0;
        for(int right=0;right<n;right++){
            currSum+=nums[right];
            while(currSum> target && left<=right){
                currSum-=nums[left];
                left++;
            }
            if(currSum==target){
                max_Len=Math.max(max_Len,right-left+1);
            }
        }

        return max_Len==-1?-1:n-max_Len;
    }
}    

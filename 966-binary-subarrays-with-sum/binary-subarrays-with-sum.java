class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int cnt=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int sum=nums[i];
            if(sum==goal) cnt++;
            for(int j=i+1;j<n;j++){
                sum+=nums[j];
                if(sum==goal) cnt++;
            }
        }
        return cnt;
    }
}
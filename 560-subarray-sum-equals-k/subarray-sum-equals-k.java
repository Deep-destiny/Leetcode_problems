class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int cnt=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            int sum=nums[i];
            if(sum==k) {
                cnt++;
            }
            for(int j=i+1;j<n;j++){
                sum+=nums[j];
                if(sum==k){ 
                    cnt++;
            }
        }
        }
        return cnt;
    }
}
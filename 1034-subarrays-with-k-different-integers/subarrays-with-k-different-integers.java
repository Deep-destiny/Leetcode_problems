class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // number of subarrays with k different numbers 
        // can we think of map , map .size will be the answer
        return fn(nums,k)-fn(nums,k-1);
    }
        private int fn(int[] nums,int k){
        int n=nums.length;
        int cnt=0;
        int j=0;
         HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);
       while(map.size()>k) {
        map.put(nums[j],map.get(nums[j])-1);
        if(map.get(nums[j])==0){
            map.remove(nums[j]);
        }
        j++;
       }
       cnt+=i-j+1;
        }
        return cnt;
}
}
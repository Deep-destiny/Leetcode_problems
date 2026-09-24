class Solution {
    public int smallestIndex(int[] nums) {
        // return smallest idx .. sum of digits of nums[i]=i;
        // if not return -1
        int smallest=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int a=nums[i];
            int sum=0;
           while(a>0){
            sum+=(a%10);
            a/=10;
           }
           if(sum==i){
                smallest=Math.min(i,smallest);
            }
        }
        return smallest==Integer.MAX_VALUE?-1:smallest;
    }
}
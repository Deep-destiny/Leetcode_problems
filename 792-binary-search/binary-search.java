class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int l=0;
        int h=n-1;
        int ans=0;
        while(l<=h){
            int mid=l+(h-l)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>target){
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return -1;
    }
}
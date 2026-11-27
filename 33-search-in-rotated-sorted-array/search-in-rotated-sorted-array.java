class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int h=n-1;  int l=0;
        while(l<=h){
            int mid=(h+l)/2;
            if(nums[mid]==target) return mid;
        
            if(nums[l]<=nums[mid]){

            if(nums[l]<=target && target<=nums[mid]){
                    h=mid-1;
                }
                else l=mid+1;
            }
            else{
                if( nums[mid]<=target && target<=nums[h]){
                    l=mid+1;
                }
                else h=mid-1;
            }
        }
        return -1;
    }
}
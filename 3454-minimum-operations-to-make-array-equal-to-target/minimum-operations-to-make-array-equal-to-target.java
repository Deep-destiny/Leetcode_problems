class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        long op=0;
        int n=nums.length;
        int []diff=new int[n];
        for(int i=0;i<n;i++){
            diff[i]=target[i]-nums[i];
        }
        int prev=0;
        int i=0;
        while(i<n){
            int curr=diff[i];
            if( (prev > 0 && curr<0) || (prev<0 && curr>0) ){
                op+=Math.abs(curr);
            }
            else if(Math.abs(curr) > Math.abs(prev)){
                op+=Math.abs(curr-prev);
            }
            prev=curr;
            i++;
        }
        return op;
    }
}
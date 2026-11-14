class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int [] res=new int [n];
        Arrays.fill(res,-1);
        int j=0;
        while(j<n){
        for(int i=0;i<nums2.length && j<n;i++){
            if(nums2[i]==nums1[j]){
                for(int k=i+1;k<nums2.length;k++){
                    if(nums2[k]>nums1[j]){
                        res[j]=nums2[k];
                        break;
                    }                       
                 }
                 break;
                }
            }
            j++;
        }
            return res;
    }
}
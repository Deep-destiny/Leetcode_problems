class Solution {
    public int findKthPositive(int[] arr, int k) {
        // using binsry search 
        int n=arr.length;
        // int []missing=new int[n];
        // for(int i=0;i<n;i++){
        //     missing[i]=arr[i]-(i+1);
        // }
        int l=0;
        int h=arr.length-1;

        while(l<=h){
            int mid=l+(h-l)/2;
            int missing=arr[mid]-(mid+1);
            if(missing<k){
                l=mid+1;
            }
            else h=mid-1;
        }
        return (h+k+1);
    }

}
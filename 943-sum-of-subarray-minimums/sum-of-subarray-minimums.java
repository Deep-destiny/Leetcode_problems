class Solution {
    int mod=1000000007;
    int n;
    public int sumSubarrayMins(int[] arr) {
         n=arr.length;
        int[] nse=findNse(arr);
        int[] psee=findPsee(arr);
        int total=0;
        for(int i=0;i<n;i++){
            int left=i-psee[i];
            int right=nse[i]-i;
            total=(int)(total+(1L*right*left*arr[i])%mod)%mod;
        }
        return total;
    }
    private int[] findNse(int[] arr){
        int []res=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            res[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return res;
    }
    private int[] findPsee(int[] arr){
        int []res=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            res[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        } 
        return res;
    }
    //     int n=arr.length;
    //     int total_sum=0;
   
    //     for(int i=0;i<n;i++){
    //             int min=Integer.MAX_VALUE;
    //         for(int j=i;j<n;j++){
    //             min=Math.min(arr[j],min);
    //              total_sum=(total_sum+min)%mod;
    //         }
    //     }
    // return total_sum%mod;
    // }

}
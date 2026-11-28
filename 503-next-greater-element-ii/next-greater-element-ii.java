class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int[] newArr=new int[nums.length*2];
        int[] res=new int[n];
        Arrays.fill(res,-1);
        for(int i=0;i<2*n;i++){
            newArr[i]=nums[i%n];
        }
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=newArr[i]){
                    st.pop();
            }
            if(st.isEmpty()){
                res[i%n]=-1;
            }
            else res[i%n]=st.peek();
            st.push(newArr[i]);
        }
        return res;
    }
}
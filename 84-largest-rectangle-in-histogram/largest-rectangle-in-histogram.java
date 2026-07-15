class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
    
        int [] right=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()] >=heights[i]){
                st.pop();
            }
            right[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
         int [] left=new int[n];
        Stack<Integer> st2=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st2.isEmpty() && heights[st2.peek()] >= heights[i]){
                st2.pop();
            }
            left[i]=st2.isEmpty()?-1:st2.peek();
            st2.push(i);
        }

        int ans=0;
        for(int i=0;i<n;i++){
            int currArea=heights[i]*(right[i]-left[i]-1);
            ans=Math.max(ans,currArea);
        }
        return ans;
    }

}
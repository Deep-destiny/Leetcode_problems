class Solution {
    
    public int maxDepth(String s) {
        int n=s.length();
        Stack<Character> st=new Stack<>();
        int max_size=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(ch);
            }
            else if(ch==')'){
                st.pop();
            }
            max_size=Math.max(st.size(),max_size);
        }
        return max_size;
    }
}
       
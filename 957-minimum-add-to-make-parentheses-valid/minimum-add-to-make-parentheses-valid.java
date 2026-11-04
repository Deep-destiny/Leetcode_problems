class Solution {
    public int minAddToMakeValid(String s) {
        /*
        () -> valid if not valid give number of brackets req to balance that out!!
        */
       Stack<Character> st=new Stack<>();
       int left_overs=0;
       for(char ch:s.toCharArray()){
        if(ch=='(') st.push(ch);
       else if(st.isEmpty() && ch==')') left_overs++;
       else if(ch==')') st.pop();
       }
       return st.size()+left_overs;
    }
}
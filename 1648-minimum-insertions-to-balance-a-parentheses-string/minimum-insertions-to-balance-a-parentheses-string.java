class Solution {
    public int minInsertions(String s) {
      int close=-2;
      int extra=0;
      Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
            st.push(ch);
        } 
        else{
            if(st.isEmpty()){
                if(i<s.length()-1 && s.charAt(i+1)==')') i++;
                else extra++;
            extra++;
        }
        else{
            if(i<s.length()-1 && s.charAt(i+1)==')'){
                i++;
            }
            else{
                extra++;
            }
            st.pop();
        }
        }
        }
        return extra+st.size()*2;
    }
}
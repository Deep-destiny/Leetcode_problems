class Solution {
    public int scoreOfParentheses(String s) {
        int n=s.length();
        Deque<Integer> st=new ArrayDeque<>();
        int score=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='('){
                st.push(score);
                score=0;
            }
            else{
                if(s.charAt(i-1)=='('){
                    score=st.peek()+1;
                }
                else{
                    score=st.peek()+(2*score);
                }
        
            st.pop();
        }
        }
        return score;
    }
        }
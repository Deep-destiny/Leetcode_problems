class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb=new StringBuilder(s);
        // boolean[] vis=new boolean[s.length()];
        while(true){
        int open=-1;
        for(int i=0;i<sb.length();i++){
            char ch=sb.charAt(i);
            if(ch=='('){
                open=i;
            }
            if(ch==')' && open!=-1){
                reverse(open,i,sb);
                 sb.deleteCharAt(i);
            sb.deleteCharAt(open);
           
            break;
            }
        }
        if(open==-1) break;
    }
return sb.toString();
    }
       private void reverse(int i1,int i2,StringBuilder sb){
            int a=i1+1;
            int b=i2-1;
            while(a<b){
                char temp=sb.charAt(a);
                sb.setCharAt(a,sb.charAt(b));
                sb.setCharAt(b,temp);
                a++;
                b--;
            }
        }
}
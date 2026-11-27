class Solution {
    public int compress(char[] chars) {
        int n=chars.length;
        StringBuilder sb=new StringBuilder();
        char prev=chars[0];
        int cnt=0;
        for(char ch:chars){
            if(ch==prev){
              cnt++;
            }
            else{
                sb.append(prev);
                if(cnt>1)sb.append(cnt);
                cnt=1;
                prev=ch;
            }
        }
        sb.append(prev);
        if(cnt>1) sb.append(cnt);
        for(int i=0;i<sb.length();i++){
            chars[i]=sb.charAt(i);
        }
        return sb.length();
    }
}
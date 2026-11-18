class Solution {
    public int minChanges(String s) {
        int zeros=0;
        int ones=0;
        for(char ch:s.toCharArray()){
            if(ch=='0')zeros++;
            else ones++;
        }
        int flag_cnt=0;
        for(int i=1;i<s.length();i+=2){
            if(s.charAt(i)!=s.charAt(i-1)) flag_cnt++;
        }
        return Math.min(flag_cnt,Math.min(zeros,ones));
    }
}
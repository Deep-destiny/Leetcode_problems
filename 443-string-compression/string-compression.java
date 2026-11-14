class Solution {
    public int compress(char[] chars) {
            int n=chars.length;
            int i=0;
            int write=0;
            while(i<n){
                char curr=chars[i];
                int cnt=0;
                while(i<n && chars[i]==curr){
                    cnt++;
                    i++;
                }
                chars[write++]=curr;
                if(cnt>1) {
                    String s=String.valueOf(cnt);
                for(char ch:s.toCharArray()){
                    chars[write++]=ch;
                }
            }   
        }
        return write;
    }
}
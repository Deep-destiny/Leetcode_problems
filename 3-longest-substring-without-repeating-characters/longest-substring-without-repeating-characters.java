class Solution {
    public int lengthOfLongestSubstring(String s) {
        boolean[] bool=new boolean[100000];
        int maxlen=0;
        int left=0;
        for(int r=0;r<s.length();r++){
            char ch=s.charAt(r);
            while(bool[ch]){
                bool[s.charAt(left)]=false;
                left++;
            }
            bool[ch]=true;
            maxlen=Math.max(r-left+1,maxlen);
        }
        return maxlen;
    }
}
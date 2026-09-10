class Solution {
    public int longestSubstring(String s, int k) {
        return rec(s,0,s.length()-1,k);
    }
    private int rec(String s,int start,int end,int k){
        if(start>end) return 0;
        int[] freq=new int[26];
        for(int i=start;i<=end;i++){
            freq[s.charAt(i)-'a']++;
        }
        for(int i=start;i<=end;i++){
            char ch=s.charAt(i);
            if(freq[ch-'a']<k){
                int left=rec(s,start,i-1,k);
                int right=rec(s,i+1,end,k);

                return Math.max(left,right);
            }
        }
        return end-start+1;

        }
}
class Solution {
    int n;
    public boolean wordBreak(String s, List<String> wordDict) {
        n=s.length();
        Boolean []dp=new Boolean[n+1];
      return rec(0,s,wordDict,dp);
    }
    private boolean rec(int idx,String s,List<String> wordDict,Boolean []dp){
        if(idx==n) return true;
        if(dp[idx]!=null) return dp[idx];
        for(String sb:wordDict){
            int len=sb.length();
            if(idx+len<=n && s.substring(idx,idx+len).equals(sb)){
                if(rec(idx+len,s,wordDict,dp) ) return dp[idx]=true;
            }
        }
        return dp[idx]=false;
    }
}
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        /*
        using wordDict we have to make String s 
        we can use word multiple times from the wordDict to create a letter in string s

         pick the word or not pick 
     Case 1:   wordDict matches char at String s so take
     Case 2: vrna  not pick  
        */

        // 1st we will go by recursion
            int n=s.length();
        Boolean[] dp=new Boolean[n];
        // Arrays.fill(dp,-1);
        return rec(s,0,wordDict,dp);        
        }

        private boolean rec(String s,int idx, List<String> wordDict,Boolean[] dp){
            if(idx==s.length()){
                return true;
            }
            if(dp[idx]!=null) return dp[idx];
            // take
            for(String word:wordDict){
                int len=word.length();
                if(idx+len<=s.length() && s.substring(idx,idx+len).equals(word)){
                
                        if(rec(s,idx+len,wordDict,dp)) return dp[idx]=true;
                    }
                }
            
            return dp[idx]=false;
        }
        }
class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s=String.valueOf(n);
        int [][][]dp=new int[11][2][2];
        for(int [][]r:dp){
            for(int []r2:r){
                Arrays.fill(r2,-1);
            }
        }
        int ans=solve(s,digits,0,true,true,dp);
        return ans-1;
    }
    int solve(String s,String[]digits,int idx,boolean tight,boolean isLeadZero,int[][][]dp){
        if(idx==s.length()) return 1;
        if(dp[idx][tight?1:0][isLeadZero?1:0]!=-1) return dp[idx][tight?1:0][isLeadZero?1:0];
        int res=0;
        int limit=tight?s.charAt(idx)-'0':9;
        if(isLeadZero){
            res+=solve(s,digits,idx+1,false,true,dp);
        }
        for(String dStr:digits){
            int dig=dStr.charAt(0)-'0';
            if(dig<=limit){
                boolean nextight=tight && (dig==limit);
                res+=solve(s,digits,idx+1,nextight,false,dp);
            }
        }
return dp[idx][tight?1:0][isLeadZero?1:0]=res;
    }
}



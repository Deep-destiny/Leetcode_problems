class Solution {
    public int findIntegers(int n) {
           String s=Integer.toBinaryString(n);
        int dp[][][]=new int[s.length()][2][2];
        for(int [][]t:dp){
            for(int []t2:t){
                Arrays.fill(t2,-1);
            }
        }
        return solve(s,0,true,false,dp);
    }
    int solve(String s,int idx,boolean tight,boolean prev,int dp[][][]){
        if(idx==s.length()) return 1;
        if(dp[idx][tight?1:0][prev?1:0]!=-1) return dp[idx][tight?1:0][prev?1:0];
        int lb=0;
        int ub=tight?s.charAt(idx)-'0':1;
        int res=0;
        for(int dig=lb;dig<=ub;dig++){
            if(dig==1 && prev) continue;
            res+=solve(s,idx+1,tight && (dig==ub),dig==1,dp);
        }
        return dp[idx][tight?1:0][prev?1:0]=res;
    }
}
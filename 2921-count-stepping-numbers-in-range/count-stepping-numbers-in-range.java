class Solution {
    final int MOD=1000000007;
    public int countSteppingNumbers(String low, String high) {
        int ans=(calc(high)-calc(low) +MOD)%MOD;
        int l=0;
        if(low.length()>=2){
       for(int i=1;i<low.length();i++){
            int a=low.charAt(i)-'0';
            int b=low.charAt(i-1)-'0';
            if(Math.abs(a-b)!=1) l++;
        }
        }
       return (l>0)?ans:(ans+1)%MOD;
    }
    int calc(String s){
        Integer[][][][] dp = new Integer[s.length()][2][2][11];
        return solve(s,0,1,1,-1,dp);
    }
    int solve(String s,int idx,int tight,int lz,int prev,Integer[][][][] dp){
        if(idx==s.length()) return 1;
        if(dp[idx][tight][lz][prev + 1] != null) return dp[idx][tight][lz][prev + 1];
        int lb=0;
        int ub=(tight==1)?s.charAt(idx)-'0':9;
        int res=0;
        for(int dig=lb;dig<=ub;dig++){
           
            int nextTight=(tight==1 && dig==ub)?1:0;
            if(lz==1 && dig==0){
                res=(res+solve(s,idx+1,nextTight,1,prev,dp))%MOD;
            }
            else{
                if ( prev==-1 || Math.abs(prev-dig)==1){
                    res=(res+solve(s,idx+1,nextTight,0,dig,dp))%MOD;
                }
            }
        }
        return dp[idx][tight][lz][prev + 1]=res;
    }
}
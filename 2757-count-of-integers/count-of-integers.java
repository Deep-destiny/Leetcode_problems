class Solution {
    final int MOD=1000000007;
    public int count(String num1, String num2, int min_sum, int max_sum) {

        int ans=(calc(num2, min_sum, max_sum) - calc(num1, min_sum, max_sum) + MOD) % MOD;
        int sum1=0;
        for(char ch:num1.toCharArray()){
            sum1+=ch-'0';
        }
        if(sum1<=max_sum && sum1>=min_sum){
            ans=(ans+1)%MOD;
        }
        return (ans%MOD);
    }
        int calc(String s,int x,int x2){
             Integer[][][][]dp=new Integer[s.length()][2][2][401];
             return solve(s,0,0,1,0,x,x2,dp);
        }
    
    int solve(String s,int sum,int idx,int tight,int lz,int x,int x2, Integer[][][][]dp){
        if(idx==s.length())
        {
if(sum<=x2 && sum>=x) return 1;
else return 0;  
        }  
        if(dp[idx][tight][lz][sum]!=null) return dp[idx][tight][lz][sum];
        int lb=0;
        int ub=(tight == 1)?s.charAt(idx)-'0':9;
        int res=0;
        for(int dig=lb;dig<=ub;dig++){
            int nextTight= (tight==1 && dig==ub)?1:0;
            if(lz==1 && dig==0){
                res+=solve(s,sum,idx+1,nextTight,1,x,x2,dp);
            }
            else{
                res+=solve(s,sum+dig,idx+1,nextTight,0,x,x2,dp);
            }
            res%=MOD;
        }
        return dp[idx][tight][lz][sum]=res;
    }
}
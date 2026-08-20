class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int num=(int)Math.pow(10,n);
        String s=String.valueOf(num-1);
        // mask 2^10 maxx posible digit(0-9)
        Integer [][][][]dp=new Integer[11][2][2][1024];
        return solve(s,0,1,1,0,dp);
        
    }

    int solve (String s,int idx,int tight,int lz,int mask, Integer [][][][]dp){
        if(idx==s.length()) return 1;
        if(dp[idx][tight][lz][mask]!=null)return dp[idx][tight][lz][mask];
        int lb=0;
        int ub=(tight==1)?s.charAt(idx)-'0':9;
        int res=0;
        for(int dig=lb;dig<=ub;dig++){
            int nextTight=(tight==1 && dig==ub)?1:0;
            if(lz==1 && dig==0){
                res+=solve(s,idx+1,nextTight,1,mask,dp);
            }
            else{
              if(((mask >> dig) & 1)==0){
              int nextMask=(mask | (1<<dig));
                res+=solve(s,idx+1,nextTight,0,nextMask,dp);
            }
        }
        }
        return dp[idx][tight][lz][mask]=res;
    }
}
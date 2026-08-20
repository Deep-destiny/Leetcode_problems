class Solution {
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        for (char c : s.toCharArray()) {
            if (c - '0' > limit) return 0;
        }
        long ans=calc(String.valueOf(finish),limit,s)- calc(String.valueOf(start-1),limit,s);
        return ans;
    }
    long calc(String strX,int limit,String s){
        if (strX.length() < s.length()) return 0;
        Long [][][]dp=new Long[strX.length()][2][2];
       return solve(strX,s,limit,0,1,1,dp);
    }
    long solve(String strX,String s,int limit,int idx,int tight,int lz,Long[][][]dp){
       if(idx==strX.length()) {
        if(lz==0) return 1;
        else return 0;
       }
       long res=0;
        if(dp[idx][tight][lz]!=null) return dp[idx][tight][lz];
        int rem=strX.length()-idx;
        if(rem<=s.length()){
            int req=s.charAt(s.length()-rem)-'0';
            if(tight==1 && req> strX.charAt(idx)-'0') return dp[idx][tight][lz]=0L;
            if(lz==1 && req==0) return dp[idx][tight][lz]=0L;
            int nexTight=(tight==1 && req==strX.charAt(idx)-'0')?1:0;
            res=solve(strX,s,limit,idx+1,nexTight,0,dp);
        }
        else{
            int ub=(tight==1)?strX.charAt(idx)-'0':9;
            ub=Math.min(ub,limit);
            for(int dig=0;dig<=ub;dig++)
            {
                int nexTight=(tight==1 && dig==strX.charAt(idx)-'0')?1:0;
                if(lz==1 && dig==0){
                    res+=solve(strX,s,limit,idx+1,nexTight,1,dp);
                }
                else{
                    res+=solve(strX,s,limit,idx+1,nexTight,0,dp);
                }
            }
        }
        return dp[idx][tight][lz]=res;
        }
}
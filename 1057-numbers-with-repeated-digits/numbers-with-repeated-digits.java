class Solution {
    public int numDupDigitsAtMostN(int n) {
        int[][][][][]dp=new int[11][2][2][2][1023];
        for(int[][][][]t:dp){
            for(int [][][]t2:t){
                for(int [][]t3:t2){
                    for(int []t4:t3){
                        Arrays.fill(t4,-1);
                    }
                }
            }
        }
        String s=String.valueOf(n);
        return fn(s,0,true,false,true,0,dp);
    }
    int fn(String s,int idx,boolean tight,boolean repetition,boolean lz,int mask,int[][][][][]dp){
        if(idx==s.length()) return repetition?1:0;
        if(dp[idx][tight?1:0][repetition?1:0][lz?1:0][mask]!=-1) return dp[idx][tight?1:0][repetition?1:0][lz?1:0][mask];
        int lb=0;
        int ub=tight?s.charAt(idx)-'0':9;
        int res=0;
        for(int dig=lb;dig<=ub;dig++){
            if(lz && dig==0){
                res+=fn(s,idx+1,(tight && dig==ub),false,true,mask,dp);
            }
            else{
                boolean isDigitUsed= (1 & (mask>>dig))==1;
                res+=fn(s,idx+1,(tight && dig==ub),(repetition || isDigitUsed),false,(mask| 1<<dig),dp);
            }
        }
        return dp[idx][tight?1:0][repetition?1:0][lz?1:0][mask]=res;
    }
}
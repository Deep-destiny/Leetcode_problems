class Solution {
   static final int MOD=1000000007;
    public int sumDecoded(long[] nums) {
        long sum=0;
        for(int i=0;i<nums.length;i++){
            int w=(int)(nums[i]%10);
            long d=(nums[i])/10;
            String s=Long.toString(d);
            long x=Long.parseLong(s.substring(0,w));
            long y=Long.parseLong(s.substring(w));
            sum=(sum+modPow(x,y,MOD))%MOD;
        }
        return (int) (sum)%MOD;
    }
    private long modPow(long base,long exp,long mod){
        long res=1;
        base%=mod;
        while(exp>0){
            if((exp&1)==1){
                res=(res*base)%mod;
            }
            base=(base*base)%mod;
            exp>>=1;
        }
        return res;
    }
}
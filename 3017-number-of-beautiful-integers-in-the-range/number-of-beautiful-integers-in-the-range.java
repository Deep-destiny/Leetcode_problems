class Solution {
    
    public int numberOfBeautifulIntegers(int low, int high, int k) {
            int ans= calc(high,k)-calc(low,k);
          int temp = low;
        int even = 0, odd = 0;
        while (temp > 0) {
            if ((temp % 10) % 2 == 0) even++;
            else odd++;
            temp /= 10;
        }
        if (even == odd && low % k == 0) {
            ans += 1;
        }
        
        return ans;
    }
    int calc(int n,int k){
        String s=String.valueOf(n);
        Integer[][][][][][]dp=new Integer[s.length()][2][2][k][11][11];
        return solve(s,0,1,1,0,0,0,k,dp);
    }
    int solve(String s,int idx,int tight,int lz,int rem,int cnt_even,int cnt_odd,int k,Integer[][][][][][]dp){
        if(idx==s.length()){
            if(lz==0 && cnt_even==cnt_odd && rem==0 ) return 1;
            else return 0;
        }
        if(dp[idx][tight][lz][rem][cnt_even][cnt_odd]!=null) return dp[idx][tight][lz][rem][cnt_even][cnt_odd];
        int lb=0;
        int ub=(tight==1)?s.charAt(idx)-'0':9;
        int res=0;
        for(int dig=lb;dig<=ub;dig++){
            int nextTight=(tight==1 && dig==ub)?1:0;
           
            if(lz==1 && dig==0){
            
                res+=solve(s,idx+1,nextTight,1,0,cnt_even,cnt_odd,k,dp);
            }
            else{
                int nextrem=(rem*10 +dig)%k;
                int a=(dig%2==0)?1:0;
                int b=(a==1)?0:1;
                res+=solve(s,idx+1,nextTight,0,nextrem,cnt_even+a,cnt_odd+b,k,dp);
            }
        }
        return dp[idx][tight][lz][rem][cnt_even][cnt_odd]=res;
    }
}
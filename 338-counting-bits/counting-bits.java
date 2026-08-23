class Solution {
    public int[] countBits(int n) {
        int[] cnt=new int[n+1];
        cnt[0]=0;
       for(int i=1;i<=n;i++){
        cnt[i]=cnt[(i & (i-1))]+1;
       }
       return cnt;
    }
}
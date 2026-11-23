class Solution {
    
    public int maxScore(int[] cardPoints, int k) {
        // pick notpick
      int n=cardPoints.length;
      int lsum=0;
      int rsum=0;
      int ans=0;
      for(int i=0;i<k;i++){
        lsum+=cardPoints[i];
      }
      ans=Math.max(lsum,ans);
      int r_ind=n-1;
      for(int j=k-1;j>=0;j--)
      {
        lsum-=cardPoints[j];
        rsum+=cardPoints[r_ind];
        r_ind--;
        ans=Math.max(ans,lsum+rsum);
      }
      return ans;
    }
}
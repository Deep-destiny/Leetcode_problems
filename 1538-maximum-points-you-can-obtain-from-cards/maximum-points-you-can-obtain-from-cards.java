class Solution {
    public int maxScore(int[] cardPoints, int k) {
          int lsum=0;
        int rsum=0;
        int max_sum=Integer.MIN_VALUE;
        for(int i=0;i<=k-1;i++ ) {
            lsum+=cardPoints[i];
            max_sum=Math.max(lsum,max_sum);
        }
        int n=cardPoints.length;
        int idx=n-1;
        for(int j=k-1;j>=0;j--){
             lsum-=cardPoints[j];
             rsum+=cardPoints[idx];
             idx--;
            max_sum=Math.max(lsum+rsum,max_sum);
        }
    return max_sum;
    }
}
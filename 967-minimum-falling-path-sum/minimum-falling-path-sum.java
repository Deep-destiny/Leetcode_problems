class Solution {
    int[][]dirs={
        {1,0},
        {1,1},
        {1,-1}
    };
    int m;
    int n;
    public int minFallingPathSum(int[][] matrix) {
        m=matrix.length;
     n=matrix[0].length;
        int min=Integer.MAX_VALUE;
        int[][] dp= new int[m][n];
        for(int[]t:dp) Arrays.fill(t,Integer.MAX_VALUE);
        for(int j=0;j<n;j++){
            int a=solve(0,j,matrix,dp);
            min=Math.min(a,min);
        }
        return min;
    }
    private int solve(int r,int c,int[][] matrix,int[][] dp){
        if(r==m-1) {
            return matrix[r][c];
        }
        if(dp[r][c]!=Integer.MAX_VALUE) return dp[r][c];
        int min=Integer.MAX_VALUE;
        for(int[]d:dirs){
            int nr=r+d[0];
            int nc=c+d[1];
            if(nr>=0 && nc>=0 && nr<m && nc<n){
                int path=matrix[r][c]+solve(nr,nc,matrix,dp);
                min=Math.min(path,min);
            }
        }
        return dp[r][c]=min;
    }
}
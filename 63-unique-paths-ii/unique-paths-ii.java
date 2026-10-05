class Solution {
    int[][]dirs={
        {0,1},
        {1,0}
    };
    int m;
    int n;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
     // obstacle 1 se mark
     // space 0 se mark
     // mtlab 0 wale pe chal skte hai bas
     m=obstacleGrid.length;
     n=obstacleGrid[0].length;
     if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1) return 0;
     int[][]dp=new int[m][n];
//      for(int []t:dp)Arrays.fill(t,-1);
//      return solve(0,0,obstacleGrid,dp);
//     }
//   private int solve(int r,int c,int[][] obstacleGrid,int[][] dp){
    // if(r==m-1 && c==n-1) return 1;
    dp[m-1][n-1]=1;
    // if(dp[r][c]!=-1) return dp[r][c];
    // int cnt=0;
    for(int i=m-1;i>=0;i--){
        for(int j=n-1;j>=0;j--){
            if(i==m-1 && j==n-1) continue;
            if(obstacleGrid[i][j]==1) {
                dp[i][j]=0;
                continue;
            }
            int cnt=0;
    for(int[]d:dirs){
        int nr=i+d[0];
        int nc=j+d[1];
        if(nr>=0 && nc>=0 && nr<m && nc<n && obstacleGrid[nr][nc]!=1){
            cnt+=dp[nr][nc];
        }
    }
    dp[i][j]=cnt;
        }
    }
    return dp[0][0];
  }
}

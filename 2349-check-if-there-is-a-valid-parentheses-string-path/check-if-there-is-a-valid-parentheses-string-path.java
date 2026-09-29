class Solution {
    int m,n;
    int[][] dirs={
        {0,1},
        {1,0}
    };
    public boolean hasValidPath(char[][] grid) {
     m=grid.length;
    n=grid[0].length;
   
     if( (m+n-1 )%2!=0 ) return false;
          if(grid[0][0]==')') return false;
     Boolean [][][]dp=new Boolean[m][n][m+n];
     return rec(0,0,1,grid,dp);
    }
    private boolean rec(int a,int b,int cnt,char[][] grid, Boolean [][][]dp){
         if(cnt<0) return false;
        if(a==m-1 && b==n-1) return cnt==0;
        if(dp[a][b][cnt]!=null) return dp[a][b][cnt];
       
        for(int []d:dirs){
            int nr=a+d[0];
            int nc=b+d[1];
            if(nr>=0 && nc>=0 && nr<m && nc<n ){
                int new_cnt=cnt;
                if(grid[nr][nc]=='(') new_cnt++;
                else new_cnt--;
                if(new_cnt >=0 && rec(nr,nc,new_cnt,grid,dp)) return dp[nr][nc][cnt]=true;
            }
        }
        return dp[a][b][cnt]=false;
    }
}
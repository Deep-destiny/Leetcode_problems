class Solution {
    int m,n;
     int[][] dirs={
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
        };
    void dfs(int r,int c,char[][]grid,boolean [][]vis){
                    vis[r][c]=true;
                    for(int []d:dirs){
                        int nr=r+d[0];
                        int nc=c+d[1];
                        if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]=='1' && !vis[nr][nc]){
                          dfs(nr,nc,grid,vis);
                        }
                    }
    }
    public int numIslands(char[][] grid) {
        // number of islands
         m=grid.length;
        n=grid[0].length;
        boolean [][]vis=new boolean[m][n];
       
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !vis[i][j]){
                  dfs(i,j,grid,vis); 
              cnt++;   
              }
               
            }
        }
        return cnt;
    }
    }
   
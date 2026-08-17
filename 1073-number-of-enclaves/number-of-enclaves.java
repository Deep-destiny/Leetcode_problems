class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        boolean [][]vis=new boolean [m][n];
        for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){

            if(i==0 | i==m-1 || j==0 || j==n-1 ){
                if(grid[i][j]==1){
                    vis[i][j]=true;
                q.offer(new int[]{i,j});
            }
            }
        }
        }
        int [][]dirs={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int []curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            for(int []d:dirs){
                int nr=r+d[0];
                int nc=c+d[1];
            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1 && !vis[nr][nc]){
                q.offer(new int[]{nr,nc});
                vis[nr][nc]=true;
            }
            }
        }
        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !vis[i][j]) cnt++;
            }
        }
    
    return cnt;
    }
}
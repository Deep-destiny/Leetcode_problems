class Solution {
    int n;
    int m;
    public int islandPerimeter(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        int perimeter=0;
        boolean [][] vis=new boolean [n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !vis[i][j]){
                    perimeter+=dfs(grid,vis,i,j);
                }
            }
        }
        return perimeter;
    }
    private int dfs(int[][]grid, boolean[][] vis,int i,int j){
        if(i<0 || j<0 || i>=n ||j>=m || grid[i][j]==0){
            return 1;
        }
        if(vis[i][j]) return 0;
vis[i][j]=true;
int perimeter=0;
perimeter+=dfs(grid,vis,i-1,j);
perimeter+=dfs(grid,vis,i+1,j);
perimeter+=dfs(grid,vis,i,j-1);
perimeter+=dfs(grid,vis,i,j+1);

return perimeter;
    }
}
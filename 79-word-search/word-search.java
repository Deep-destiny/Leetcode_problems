class Solution {
    int n;
    int m;
    int[][] dirs={
        {0,1},
        {0,-1},
        {1,0},
        {-1,0}
    };
    public boolean exist(char[][] board, String word) {
        // questn:
        // bfs
        n=board.length;
        m=board[0].length;
        boolean [][] vis=new boolean[n][m]; 
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
        if(dfs(i,j,board,word,vis,0)) return true;
            }
        }
         return false;
        }
    private boolean dfs(int i,int j,char[][] board,String word,boolean[][] vis,int idx){
        if(idx==word.length()) return true;
        if(i<0 ||j<0 || i>=n || j>=m || vis[i][j] ||board[i][j]!=word.charAt(idx)) return false;
 vis[i][j]=true;
        for(int []d:dirs){
            int nr=i+d[0];
            int nc=j+d[1];
                if(dfs(nr,nc,board,word,vis,idx+1) ) return true;
        }
    vis[i][j]=false;
    return false;
}
}
class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        boolean vis[][]=new boolean[m][n];
        for(int k=0;k<m;k++){
            if(board[k][0]=='O') helper(board,vis,k,0,m,n);
            if(board[k][n-1]=='O') helper(board,vis,k,n-1,m,n);
        }
        for(int a=0;a<n;a++){
            if(board[0][a]=='O') helper(board,vis,0,a,m,n);
            if(board[m-1][a]=='O') helper(board,vis,m-1,a,m,n);
        }
        for(int b=0;b<m;b++){
            for(int c=0;c<n;c++){
                if(board[b][c]=='O' && !vis[b][c]) board[b][c]='X';
            }
        }
    }

      private void helper(char[][] board,boolean vis[][],int i,int j,int m,int n){
      
      if(i<0 ||i>=m ||j<0 || j>=n || vis[i][j]==true || board[i][j]=='X') return;
vis[i][j]=true;
helper(board,vis,i+1,j,m,n);
helper(board,vis,i-1,j,m,n);
helper(board,vis,i,j+1,m,n);
helper(board,vis,i,j-1,m,n);
    }
}
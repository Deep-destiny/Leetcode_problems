class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
     int freshcnt=0;
     Queue<int[]> q=new LinkedList<>();
     for(int i=0;i<m;i++){
     for(int j=0;j<n;j++){

        if(grid[i][j]==2){
            q.offer(new int[]{i,j});
        }
        else if(grid[i][j]==1) freshcnt++;
     }   
     }
     if(freshcnt==0) return 0;
    int mins=0;
    int[][]dirs= { {1,0},{-1,0},{0,1},{0,-1} };
    while(!q.isEmpty()){
        int N=q.size();
        while(N-->0){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
              for(int []d:dirs){
        int r_new=r+d[0];
        int c_new=c+d[1];
        if(r_new<m && c_new<n && r_new>=0 && c_new>=0 && grid[r_new][c_new]==1){
            grid[r_new][c_new]=2;
            freshcnt--;
            q.offer(new int[]{r_new,c_new});
        }
        }
    }
    mins++;
    }
    return freshcnt>0? -1:mins-1;
    }
}
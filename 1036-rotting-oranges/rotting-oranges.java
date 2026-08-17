class Solution {
    public int orangesRotting(int[][] grid) {
      if(grid==null || grid.length==0) return -1;
      int n=grid.length;
      int m=grid[0].length;
      Queue<int[]> q=new LinkedList<>();
      int freshcnt=0;
      for(int r=0;r<n;r++){
        for(int c=0;c<m;c++){
            if(grid[r][c]==2){
                q.add(new int[]{r,c});
            }
            else if (grid[r][c]==1){
                freshcnt++;
            }
        }
      }

      if(freshcnt==0)return 0;
      int mins=0;
      int[][]dirs={{1,0},{0,1},{0,-1},{-1,0}};
      while(!q.isEmpty() && freshcnt>0){
            int size=q.size();
            for(int i=0;i<size;i++){
                int []curr=q.poll();
                int r=curr[0];
                int c=curr[1];
                for(int []d :dirs){
                    int nr=r+d[0];
                    int nc=c+d[1];

                    if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]==1){
                        grid[nr][nc]=2;
                        freshcnt--;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
            mins++;
      }
return freshcnt==0?mins:-1;
    }
}
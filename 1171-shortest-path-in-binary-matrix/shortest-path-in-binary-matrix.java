class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(
            grid[0][0]!=0 || grid[m-1][n-1]!=0
        ) return -1;
        int[][] dirs={
            {0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,1},{-1,1},{1,-1}
        };
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,0});
        grid[0][0]=1;
        int distance=1;
        while(!q.isEmpty()){
            int N=q.size();
            while(N-->0){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
              if(r==m-1 && c==n-1) return distance;
            for(int []d:dirs){
                int r_new=r+d[0];
                int c_new=c+d[1];

                if(r_new <m && r_new>=0 && c_new<n && c_new>=0 && grid[r_new][c_new]==0){
                   grid[r_new][c_new]=1;
                    q.offer(new int[]{r_new,c_new});
                }
            }
            }
            distance++;
        }
            return -1;
    }
}
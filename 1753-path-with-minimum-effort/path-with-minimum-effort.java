class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int m=heights.length;
        int n=heights[0].length;
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int[][] dist=new int[m][n];
        for(int []d:dist) Arrays.fill(d,Integer.MAX_VALUE);
        q.offer(new int[]{0,0,0});
        int[][] dirs={
            {0,1},
            {1,0},
            {-1,0},
            {0,-1}
            };
        while(!q.isEmpty()){
          
                int []curr=q.poll();
                int effort=curr[0];
                int r=curr[1];
                int c=curr[2];
                if(r==m-1 && c==n-1) return effort;
                for(int[] d:dirs){
                    int nr=r+d[0];
                    int nc=c+d[1];
                    if(nr>=0 && nc>=0 && nr<m && nc<n){
                        int edge_effort=Math.abs(heights[r][c]-heights[nr][nc]);
                        int new_effort=Math.max(effort,edge_effort);
                        if(new_effort<dist[nr][nc]){
                            dist[nr][nc]=new_effort;
                            q.offer(new int[]{new_effort,nr,nc});
                        }
                    }
                }
            }
        return 0;
    }
}
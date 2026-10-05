class Solution {
    int [][]dirs={
        {1,0},
        {1,1}
    };
    int m;
    int n;
    public int minimumTotal(List<List<Integer>> triangle) {
        m=triangle.size();
       int[][]dp=new int[m+1][m+1];
       for(int[]t:dp)Arrays.fill(t,Integer.MAX_VALUE);
       return solve(0,0,triangle,dp);
    }
    private int solve(int r,int c,List<List<Integer>> triangle,int[][] dp){
        if(r==m-1) return triangle.get(r).get(c);
        if(dp[r][c]!=Integer.MAX_VALUE) return dp[r][c];
        int min=Integer.MAX_VALUE;
        for(int[]d:dirs){
            int nr=r+d[0];
            int nc=c+d[1];
            if( nr<m && nc<triangle.get(nr).size()){
                int path=triangle.get(r).get(c)+solve(nr,nc,triangle,dp);
                min=Math.min(path,min);
            }
        }
        return dp[r][c]=min;
    }
}

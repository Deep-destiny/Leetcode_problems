class Solution {
    public int countSquares(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int ans=0; 
        int[][] dabba=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
              if(matrix[i][j]==1){
                if(i==0 || j==0){
                    dabba[i][j]=1;
                }
                else{
                dabba[i][j]=Math.min(dabba[i-1][j],Math.min(dabba[i-1][j-1],dabba[i][j-1])) + 1;
            }
            ans+= dabba[i][j] ;
              }
        }
    }
  
    return ans;
    }
}
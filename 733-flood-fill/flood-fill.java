class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int m=image.length;
        int n=image[0].length;
        boolean [][]vis=new boolean[m][n];
        helper(image,sr,sc,vis,color,image[sr][sc]);
        return image;
    }
    private void helper(int[][] image, int sr, int sc,boolean [][]vis, int color,int orgcol){
        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length|| 
        image[sr][sc]!=orgcol || vis[sr][sc]==true) return ;

        vis[sr][sc]=true;
        image[sr][sc]=color;
        helper(image,sr+1,sc,vis,color,orgcol);
        helper(image,sr-1,sc,vis,color,orgcol);
        helper(image,sr,sc+1,vis,color,orgcol);
        helper(image,sr,sc-1,vis,color,orgcol);

    }
}
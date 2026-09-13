class Solution {
    int n;
    public int largestOverlap(int[][] img1, int[][] img2) {
        // slide all left to left right down or up poora grid bro 
        // choice 1 : img1 ko slide kre aur img2 se compare kre
        // choice 2: img2 ko slide kre aur img1 se compare kre
        // goal of sliding is to maximize or to get closest to the comparable ones
        n=img1.length;
       return dfs(img1,img2);
    }
    private int dfs(int[][] img1,int[][] img2){
        int max=0;
        for(int rs=-(n-1);rs<=n-1;rs++){
            for(int cs=-(n-1);cs<=n-1;cs++){
                int cnt=0;
                for(int i=0;i<n;i++){
                    for(int j=0;j<n;j++){
                        int x=i+rs;
                        int y=j+cs;

                        if(x>=0 && x<n && y>=0 && y<n){
                            if(img1[i][j]==1 && img2[x][y]==1){
                                cnt++;
                            }
                        }
                    }
                }
                max=Math.max(max,cnt);
            }
        }
        return max;
        }
}
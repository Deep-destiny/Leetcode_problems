class Solution {
    public int findCircleNum(int[][] isConnected) {
        int V=isConnected.length;
        int cnt=0;
        boolean [] vis=new boolean [V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                cnt++;
                dfs(i,isConnected,vis,V);
            }
        }
        return cnt;
    }
    private void dfs(int idx,int[][] isConnected,boolean [] vis,int V){
        vis[idx]=true;
        for(int j=0;j<V;j++){
            if(isConnected[idx][j]==1 && !vis[j]){
                dfs(j,isConnected,vis,V);
            }
        }
    }
}
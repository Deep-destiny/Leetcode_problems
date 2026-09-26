class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int V=edges.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
       
        for(int i=0;i<=V;i++){
            adj.add(new ArrayList<>());
        }
        for(int []e:edges){
            int u=e[0];
            int v=e[1];
             boolean [] vis=new boolean[V+1];
             if(dfs(adj,u,v,vis)) return e;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return new int[0];
    }
    private boolean dfs(  ArrayList<ArrayList<Integer>> adj,int u,int v,boolean [] vis){
        vis[u]=true;
        if(u==v) return true;
        for(int nei:adj.get(u)){
            if(vis[nei]) continue;
            
              if( dfs(adj,nei,v,vis) ) return true;
            }
            return false;
        }
}
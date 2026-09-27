class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // 1st approach ->dfs
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean [] vis=new boolean[n];
        return dfsPathExist(source,destination,adj,vis);
    }
    private boolean dfsPathExist(int node,int dest,ArrayList<ArrayList<Integer>>adj,boolean [] vis){
        if(node==dest) return true;
        vis[node]=true;
        for(int nei:adj.get(node)){
            if(!vis[nei]) {
                if(dfsPathExist(nei,dest,adj,vis)) return true;
            }
        }
        return false;
    }
}
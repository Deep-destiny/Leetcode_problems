class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // 1st approach ->dfs
       List<Integer>[] adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj[u].add(v);
            adj[v].add(u);
        }

        boolean [] vis=new boolean[n];
        return dfsPathExist(source,destination,adj,vis);
    }
    private boolean dfsPathExist(int node,int dest,List<Integer>[] adj,boolean [] vis){
        if(node==dest) return true;
        vis[node]=true;
        for(int nei:adj[node]){
            if(!vis[nei]) {
                if(dfsPathExist(nei,dest,adj,vis)) return true;
            }
        }
        return false;
    }
}
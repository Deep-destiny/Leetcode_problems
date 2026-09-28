class Solution {
    public boolean isBipartite(int[][] graph) {
          int V=graph.length;
        ArrayList<Integer>[] adj=new ArrayList[V];
        for(int i=0;i<V;i++){
            adj[i]=new ArrayList<>();
            for(int g:graph[i]){
                adj[i].add(g);
            }
        }
      
        int [] color=new int[V];
        Arrays.fill(color,-1);
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(color[i]==-1){
                q.add(i);
                color[i]=1;
                while(!q.isEmpty()){
                    int curr=q.poll();
                    for(int nei:adj[curr]){
                        if(color[nei]==-1){
                            if(color[curr]==1) color[nei]=0;
                            else  color[nei]=1;
                              q.offer(nei);
                        }
                        else{
                       if(color[nei]==color[curr]) return false;
                    }
                    }
                }
            }
        }
        return true;
    }
}
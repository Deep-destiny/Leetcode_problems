class Solution {
    public boolean isBipartite(int[][] graph) {
          int V=graph.length;   
        int [] color=new int[V];
        Arrays.fill(color,-1);
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(color[i]!=-1) continue;
                color[i]=1;
                  q.add(i);
                while(!q.isEmpty()){
                    int curr=q.poll();
                    for(int nei:graph[curr]){
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
        return true;
    }
}
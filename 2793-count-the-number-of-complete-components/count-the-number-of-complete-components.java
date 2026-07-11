class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph=new ArrayList[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int []e:edges){
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        int ans=0;
        boolean []vis=new boolean [n];
        for(int i=0;i<n;i++){

            if(!vis[i]){

                int[] info=new int[2];

            dfs(i,graph,vis,info);

                int nodes=info[0];
                int edgecnt=info[1]/2;

                if(edgecnt== (nodes*(nodes-1)/2)){
                    ans++;
                }
            }

        }
return ans;
    }
    

private void dfs(int node,List<Integer>[] graph,boolean [] vis,int[] info){


    vis[node]=true;

info[0]++;
info[1]+=graph[node].size();
for(int nei:graph[node]){
    if(!vis[nei]){
        dfs(nei,graph,vis,info);
    }
}
}
    
}
class Solution {


static class Pair{
    int u;
    int v;
    int w;
    Pair(int u,int v,int w){
        this.u=u;
        this.v=v;
        this.w=w;
    }
}

    public int networkDelayTime(int[][] times, int n, int k) {
        
        // Adjacency List

        List<List<Pair>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

    for(int []t:times){
        int u=t[0];
        int v=t[1];
        int w=t[2];
        graph.get(u).add(new Pair(u,v,w));
    }


int []dist=new int[n+1];
Arrays.fill(dist,Integer.MAX_VALUE);

        dist[k]=0;

        // pq store     {node,dist}
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
pq.offer(new int[]{k,0});

while(!pq.isEmpty()){
    int[] curr=pq.poll();
    int node=curr[0];
    int currdist=curr[1];

    if(currdist>dist[node]){
        continue;
    }

    for(Pair edge:graph.get(node)   ){
        int nxt=edge.v;
        int wt=edge.w;

       if(  currdist + wt<dist[nxt] ){
        dist[nxt]=   currdist+wt;
        pq.offer(new int[]{nxt,dist[nxt]});
       }
    }
}
int ans=0;


for(int i=1;i<=n;i++){
    if(dist[i]==Integer.MAX_VALUE){
        return -1;
    }
    ans=Math.max(ans,dist[i]);
}
return ans;
    }
}







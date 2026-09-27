class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for (int[] t : times) {
    int u = t[0];
    int v = t[1];
    int wt = t[2];

    adj.get(u).add(new int[]{v, wt});
}
        int[] dist= new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<>( (a,b)-> a[0]-b[0]);
        pq.offer(new int[]{0,k});
    while(!pq.isEmpty()){
            int []top=pq.poll();
            int d=top[0];
            int u=top[1];
            if(d> dist[u]) continue;
            for(int[] p:adj.get(u)){
                int v=p[0];
                int wt=p[1];
                if(dist[u]+wt< dist[v]){
                    dist[v]=dist[u]+wt;
                    pq.offer(new int[]{dist[v],v});
                }
            }
        }
        int max=-1;
        for(int i=1;i<=n;i++){
           if(dist[i]==Integer.MAX_VALUE) return -1;
           max=Math.max(max,dist[i]);
        }
        
    return max==Integer.MAX_VALUE?-1:max;
    }
}
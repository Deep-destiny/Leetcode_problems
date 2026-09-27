class DSU{
    int []par;
    int [] rank;
    public DSU(int n){
        par=new int[n];
        rank=new int[n];
        for(int i=1;i<n;i++){
            par[i]=i;
            rank[i]=0;
        }
    }
    public int findPar(int x){
        if(x==par[x]) return x;
        return par[x]=findPar(par[x]);
    }
    public void union(int x,int y){
            int x_par=findPar(x);
            int y_par=findPar(y);
            if(x_par == y_par) return ;
            if(rank[x_par]<rank[y_par]){
                par[x_par]= y_par;
            }
            else if(rank[x_par]>rank[y_par]){
                par[y_par]=x_par;
            }
            else {
                par[y_par]=x_par;
                rank[x_par]++;
            }
    }

}

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
       // 2nd dsu
    DSU dsu=new DSU(n);
    for(int [] e:edges){
        int u=e[0];
        int v=e[1];
        dsu.union(u,v);
    }
    return dsu.findPar(source)==dsu.findPar(destination);
}
}


class DSU{
        int[] par;
        int[] rank;
    public DSU(int n){
        par=new int[n+1];
        rank=new int[n+1];
        for(int i=1;i<=n;i++){
            par[i]=i;
            rank[i]=0;
        }
    }

    public int find(int x){
        if(x==par[x]) return x;
        return par[x]=find(par[x]); // path compression
    }
    public void union (int x,int y){
        int x_par=find(x);
        int y_par=find(y);
        if(x_par == y_par) return ;
        if(rank[x_par]> rank[y_par]){
            par[y_par]=x_par;
        }
       else if(rank[x_par] < rank[y_par]){
            par[x_par]=y_par;
        }
        else{
            par[y_par]=x_par;
            rank[x_par]++;
                    }
    }

}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int n=edges.length;
        DSU dsu=new DSU(n);
     for(int []e:edges){
        int u=e[0];
        int v=e[1];

        if(dsu.find(u)==dsu.find(v)){
            return e;
        }
        dsu.union(u,v);
     }
     return new int[0];
    }
}
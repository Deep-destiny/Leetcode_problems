class Solution {
    class DisjointSet{
        List<Integer> par=new ArrayList<>();
        List<Integer> rank=new ArrayList<>();
        List<Integer> size=new ArrayList<>();
        public DisjointSet(int n){
            for(int i=0;i<n;i++){
                rank.add(0);
                par.add(i);
                size.add(1);
            }
        }
        public int findUPar(int node){
            if(node==par.get(node)) return node;
            int ulp=findUPar(par.get(node));
            par.set(node,ulp);
            return par.get(node);
        }
        public void UnionBysize(int u,int v){
            int ulp_u=findUPar(u);
            int ulp_v=findUPar(v);
            if(ulp_u == ulp_v) return;
                if(size.get(ulp_u)<size.get(ulp_v)){
                    par.set(ulp_u,ulp_v);
                    size.set(ulp_v,size.get(ulp_v)+size.get(ulp_u));
                }
                else{
                    par.set(ulp_v,ulp_u);
                    size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
                }
            }
        }
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds=new DisjointSet(n);
        int cntExtras=0;
        int m=connections.length;
        for(int i=0;i<m;i++){
            int u=connections[i][0];
            int v=connections[i][1];
            if(ds.findUPar(u)==ds.findUPar(v)){
                cntExtras++;
            }
            else{
                ds.UnionBysize(u,v);
            }
        }
        int cntC=0;
        for(int i=0;i<n;i++){
            if(ds.par.get(i)==i) cntC++;
        }
            int ans=cntC-1;
            if(cntExtras>=ans) return ans;
            return -1;
        }
}
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int []e:dislikes){
            int u=e[0];
            int v=e[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        int[] color=new int[n+1];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i]!=-1) continue;
            color[i]=1;
            if(colorSame(i,graph,color)) return false;
            }
        return true;
    }
    private boolean colorSame(int curr,ArrayList<ArrayList<Integer>> graph,int[] color){
       
      
        for(int nei:graph.get(curr)){

            if(color[nei]==-1){
            color[nei]=1-color[curr];
               if(colorSame(nei,graph,color)) return true;
        }
             
            else if(color[curr]==color[nei]) return true;
        }
        return false;
    }
}
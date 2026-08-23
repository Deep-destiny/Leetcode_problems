class Solution {
    int root_result;
    int[] cnt;
    int N;
    int DfsBase(ArrayList<Integer>[] adj,int curr_node,int prev_node,int curr_doorie){

        int total_cnt=1;
        root_result+=curr_doorie;
        for(int nei:adj[curr_node]){
            if(nei==prev_node) continue;
            total_cnt+=DfsBase(adj,nei,curr_node,curr_doorie+1);
        }
        cnt[curr_node]=total_cnt;
        return total_cnt;
    }

        void Dfs(ArrayList<Integer>[] adj,int par_node,int prev_node,int[]res){
            for(int child:adj[par_node]){
                if(child==prev_node) continue;
                res[child]=res[par_node]-cnt[child]+(N-cnt[child]);
                Dfs(adj,child,par_node,res);
            }
        }

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        N=n;
        cnt=new int[n];
        ArrayList<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++) adj[i]=new ArrayList<>();
        for(int []e:edges){
            int u=e[0];
            int v=e[1];
            adj[u].add(v);
            adj[v].add(u);
        }
        root_result=0;
        DfsBase(adj,0,-1,0);
        int[]res=new int[n];
        Arrays.fill(res,0);
        res[0]=root_result;
        Dfs(adj,0,-1,res);
        return res;
    }
}
class Solution {
    private boolean ToposortDfs(int curr,ArrayList<ArrayList<Integer>> adj,boolean [] vis,boolean [] pathvis, Stack<Integer> st){
        vis[curr]=true;
        pathvis[curr]=true;
        for(int nei:adj.get(curr)){
            if(pathvis[nei]) return true;
            if(!vis[nei]){
                if(ToposortDfs(nei,adj,vis,pathvis,st)) return true;
            }
        }
            pathvis[curr]=false;
            st.push(curr);
            return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n=numCourses;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        for (int[] p : prerequisites) {
            int a = p[0];
            int b = p[1];
            adj.get(b).add(a);
        }
            Stack<Integer> st=new Stack<>();
            boolean [] vis=new boolean[n];
            boolean [] pathvis=new boolean[n];
            for(int i=0;i<n;i++){
                if(!vis[i]){
                    // if cycle found
                       if(ToposortDfs(i,adj,vis,pathvis,st)) return new int[0];
                }
            }
            int[] ans=new int[n];
            int idx=0;
            while(!st.isEmpty()){
                ans[idx++]=st.pop();
            }
            return ans;
    }
}

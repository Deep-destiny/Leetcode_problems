class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        boolean [] edge=new boolean[queries.length];
        int []comp=new int[n];
        int id=0;
    
        comp[0]=0;
        for(int i=1;i<n;i++){
            if(nums[i]-nums[i-1] >maxDiff) id++;
            comp[i]=id;
        }

        for(int i=0;i<queries.length;i++){
            int a=queries[i][0];
            int b=queries[i][1];
            edge[i]=(comp[a]==comp[b]);
            }
        return edge;
    }
}



class Solution {
    int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestPathAllKeys(String[] grid) {
        
        int m=grid.length;
        int n=grid[0].length();
        Queue<int[]> q=new LinkedList<>();
        int cnt=0;
        for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){

            char ch=grid[i].charAt(j);
            if(ch=='@'){
                q.offer(new int[]{i,j,0,0});
            }
            else if(ch>='a' && ch<='f') cnt++;
        }
        }
        int finalKeyMask= (1<<cnt)-1;
        boolean [][][]vis=new boolean [m][n][finalKeyMask+1];
        while(!q.isEmpty()){
            int[] temp=q.poll();
            int i=temp[0];
            int j=temp[1];
            int steps=temp[2];
            int keyMask=temp[3];


            if(keyMask==finalKeyMask) return steps;

            for(int[]dir:dirs){
                int ni=i+dir[0];
                int nj=j+dir[1];

                if(ni<0 ||ni>=m || nj<0 ||nj>=n) continue;
                //wall
                if(grid[ni].charAt(nj)=='#'){
                    continue;
                }
                char ch=grid[ni].charAt(nj);
                // lock
                if(ch>='A' && ch<='F'){
                    int key=ch-'A';
                    if((keyMask & (1<<key))==0) continue;
                    if(vis[ni][nj][keyMask]) continue;
                    vis[ni][nj][keyMask]=true;
                    q.offer(new int[]{ni,nj,steps+1,keyMask});
                }
                //key
                else if(ch>='a' && ch<='f'){
                    int newKeyMask=keyMask | (1<< (ch-'a'));
                    if(vis[ni][nj][newKeyMask]) continue;
                    vis[ni][nj][newKeyMask]=true;
                    q.offer(new int[]{ni,nj,steps+1,newKeyMask});
                }
                // empty/start
                else{
                    if(vis[ni][nj][keyMask]) continue;
                    vis[ni][nj][keyMask]=true;
                    q.offer(new int[]{ni,nj,steps+1,keyMask});
                }
            }
        }
        return -1;
    }
}
     
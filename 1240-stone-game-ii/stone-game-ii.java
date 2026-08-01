class Solution {
    public int stoneGameII(int[] piles) {
        int t[][][]=new int [2][101][101];
        for(int [][]row:t){
            for(int[] r:row){
            Arrays.fill(r,-1);
            }
        }
        return solve(1,0,1,piles,t);
    }
    private int solve(int person,int i,int M,int [] piles,int [][][]t){
        int n=piles.length;
        if(i>=n) return 0;
        if(t[person][i][M]!=-1) return t[person][i][M];
        int stones=0;
        int result=(person==1)?-1:Integer.MAX_VALUE;
        for(int x=1;x<=Math.min(2*M,n-i);x++){
            stones+=piles[i+x-1];
            if(person==1){
                result=Math.max(result,stones+solve(0,i+x,Math.max(x,M),piles,t));
            }
            else{
                result=Math.min(result,solve(1,i+x,Math.max(x,M),piles,t));
            }
        }
        return t[person][i][M]=result;
    }
}
class Solution {
    
    int solve(String s,int idx,boolean tight,int cnt_of_1,int[][][]t){
        if(idx==s.length())return cnt_of_1;
        if(t[idx][tight?1:0][cnt_of_1]!=-1) return t[idx][tight?1:0][cnt_of_1];
        int lb=0;
        int ub=tight?s.charAt(idx)-'0':9;
        int res=0;
        for(int dig=lb;dig<=ub;dig++){
            res+=solve(s,idx+1,tight && (dig==ub),cnt_of_1+ (dig==1?1:0),t);
        }
        return t[idx][tight?1:0][cnt_of_1]=res;
    }
    public int countDigitOne(int n) {
        String s=String.valueOf(n);
        int [][][]t=new int[11][2][10];
        for(int[][]r:t){
            for(int []c:r){
        Arrays.fill(c,-1);
            }
        }
        return solve(s,0,true,0,t);
    }
}
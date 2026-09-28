class Solution {
    
    public int maxDepth(String s) {
        int n=s.length();
        int cnt=0;
        int max_cnt=Integer.MIN_VALUE;
        for(char ch:s.toCharArray()){
            if(ch=='(') cnt++;
            else if(ch==')') cnt--;
            max_cnt=Math.max(cnt,max_cnt);
        }
        return max_cnt;
    }
}
       
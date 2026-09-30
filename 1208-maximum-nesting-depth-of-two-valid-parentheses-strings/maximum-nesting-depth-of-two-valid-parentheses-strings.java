class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int[] res=new int[seq.length()];
        for(int i=0;i<seq.length();i++){
            if(seq.charAt(i)=='(') res[i]= i%2;
            else res[i]=1-i%2;
        }
        return res;
    }
}
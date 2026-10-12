class Solution {
    public int minTimeToType(String word) {
        char start='a';
        int sum=0;
        
        for(char ch:word.toCharArray()){
            int curr=Math.abs(ch-start);
            int move=Math.min(curr,26-curr);
            sum+=move+1;
            start=ch;
        }
        return sum;
    }
}
class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        int j=1;
        for(char ch:s.toCharArray()){
           int ind='z'- ch + 1;
            sum+= (j * ind);
            j++;
        }
        return sum;
    }
}
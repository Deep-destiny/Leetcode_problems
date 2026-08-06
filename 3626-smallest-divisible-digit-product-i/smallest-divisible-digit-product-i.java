class Solution {
    public int smallestNumber(int n, int t) {
        
        if(n==0 || n>100 || t>10)return 0;
        int prod=1;
        int temp=n;
        while(temp>0){
            prod*=(temp%10);
            temp=temp/10;
        }
        if(prod% t!=0) return smallestNumber(n+1,t);
        return n;
    }
}
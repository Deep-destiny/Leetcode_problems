class Solution {
    public int gcdOfOddEvenSums(int n) {
        int a=1;
        int b=2;
        int sumEven=0,sumOdd=0;
        if(n==1) return gcd(a,b);
        while(n>0){
            sumOdd+=a;
            sumEven+=b;
            a+=2;
            b+=2;
            n--;
        }
        return gcd(sumEven,sumOdd);
    }
    private int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
}
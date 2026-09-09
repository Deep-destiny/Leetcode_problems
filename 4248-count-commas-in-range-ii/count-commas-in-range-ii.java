class Solution {
    public long countCommas(long n) {
        long total=0;
        long start=1000;
        int comma=1;
        // n =10,000,000
        while(start<=n){
            long end=start*1000 - 1;
            long count=Math.min(n,end)-start +1;
            total+=count*comma; //1st loop=total=999000
            start*=1000;// start=1,000,000
            comma++; //comma=2
            //then 2nd loop and total=999000+new total;
        }
        return total;
        
    }
}
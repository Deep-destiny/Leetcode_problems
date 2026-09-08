class Solution {
    public int countCommas(int n) {
        //count commas > inserted after every 3 digits from the right
        /*
        n/1000 if !=0 insert 0

        */
        if(n<1000) return 0;
        return (n - 1000) +1;
    }
    /*
    optimized  return n-1000 +1
    */
}
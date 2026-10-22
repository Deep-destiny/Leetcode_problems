class Solution {
    public int countPrimes(int n) {
        // count prime 
        if(n<=2) return 0;
      List<Integer> primes=new ArrayList<>();
      boolean [] isPrime=new boolean[n];
    for(int i=2;i<n;i++) isPrime[i]=true;
    for(int i=2;i<n;i++){
        if(isPrime[i]) primes.add(i);
        for(int p:primes){
            if(i*p>=n) break;
            isPrime[i*p]=false;
            if(i%p==0) break;
        }
    }
    return primes.size();
    }
}
class Solution {
    public int[] decrypt(int[] code, int k) {
        int n=code.length;
        int[] prefix=new int[2*n+1];
        int [] res=new int[n];
         if(k==0){
          Arrays.fill(res,0);
          return res;
        }
        prefix[0]=0;
        for(int i=0;i<2*n;i++){
            prefix[i+1]=prefix[i]+code[i%n];
        }
       
        
        for(int i=0;i<n;i++){
            if(k>0){
            res[i]=prefix[i+k+1]-prefix[i+1];
        }
            else{
                res[i]=prefix[i+n]-prefix[i+n+k];
            }
        }
       return res;
    }
}
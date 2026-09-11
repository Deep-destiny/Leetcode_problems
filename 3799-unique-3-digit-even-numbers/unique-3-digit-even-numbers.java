class Solution {
    HashSet<Integer> set= new HashSet<>();
    public int totalNumbers(int[] digits) {
        //we have to use 1 digit exactly once....
        // count the number of 3 digit even numbers formed by these digits
        boolean [] vis=new boolean [digits.length];
        rec(digits,vis,0,0);
        return set.size();
    }
    private void rec(int []digits,boolean [] vis,int idx,int num){
        if(idx==3){
          set.add(num);
          return;
        }
        for(int i=0;i<digits.length;i++){
            if(vis[i]) continue;
       if(idx==0 && digits[i]==0) continue;
       if(idx==2 && digits[i]%2!=0) continue;

       vis[i]=true;
       rec(digits,vis,idx+1,num*10+digits[i]);
       vis[i]=false;
    }
}
}
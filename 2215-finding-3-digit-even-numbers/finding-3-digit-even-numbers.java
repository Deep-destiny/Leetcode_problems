class Solution {
    HashSet<Integer> set=new HashSet<>();
    public int[] findEvenNumbers(int[] digits) {
        boolean [] vis=new boolean[digits.length];
        rec(digits,vis,0,0);
        int[] arr=set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(arr);
        return arr;
    }
    void rec(int[] digits,boolean []vis,int idx,int num){
        if(idx==3){
            set.add(num);
            return;
        }
        for(int i=0;i<digits.length;i++){
            if(idx==0 && digits[i]==0) continue;
            if(idx==2 && digits[i]%2!=0)continue;

            if(vis[i]) continue;
            vis[i]=true;
            rec(digits,vis,idx+1,num*10+digits[i]);
            vis[i]=false;
        }
    }
}
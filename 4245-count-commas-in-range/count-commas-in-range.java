class Solution {
    public int countCommas(int n) {
        //count commas > inserted after every 3 digits from the right
        /*
        n/1000 if !=0 insert 0

        */
        if(n<1000) return 0;
        int cnt=0;
        for(int i=1000;i<=n;i++){
            int temp=i;
            while(temp>0){
                temp/=1000;
                if(temp!=0) cnt++;
            }
        }
        return cnt;
    }
}